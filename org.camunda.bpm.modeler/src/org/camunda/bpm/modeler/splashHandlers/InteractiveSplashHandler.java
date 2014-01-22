
package org.camunda.bpm.modeler.splashHandlers;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.splash.AbstractSplashHandler;

import de.cas.open.prozesse.modeler.server.eimInterface.AuthenticationUtil;
import de.cas.open.prozesse.modeler.server.preferences.PreferenceConstants;
import de.cas.open.prozesse.modeler.server.utils.EncryptionUtil;

/**
 * @since 3.3
 * 
 */
public class InteractiveSplashHandler extends AbstractSplashHandler {
	
	private final static int F_LABEL_HORIZONTAL_INDENT = 175;

	private final static int F_BUTTON_WIDTH_HINT = 80;

	private final static int F_TEXT_WIDTH_HINT = 175;
	
	private final static int F_COLUMN_COUNT = 3;
	
	private Composite fCompositeLogin;
	
	private Text fTextServerUrl;
	
	private Text fTextMandant;
	
	private Text fTextUsername;
	
	private Text fTextPassword;
	
	private Button fButtonOK;
	
	private Button fButtonCancel;
	
	private boolean fAuthenticated;
	
	/**
	 * 
	 */
	public InteractiveSplashHandler() {
		fCompositeLogin = null;
		fTextServerUrl = null;
		fTextMandant = null;
		fTextUsername = null;
		fTextPassword = null;
		fButtonOK = null;
		fButtonCancel = null;
		fAuthenticated = false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.splash.AbstractSplashHandler#init(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	public void init(final Shell splash) {
		// Store the shell
		super.init(splash);
		// Configure the shell layout
		configureUISplash();
		// Create UI
		createUI();		
		// Create UI listeners
		createUIListeners();
		// Force the splash screen to layout
		splash.layout(true);
		splash.addTraverseListener(new TraverseListener() {
			@Override
			public void keyTraversed(final TraverseEvent event) {
				if (event.detail == SWT.TRAVERSE_RETURN) {
				    handleButtonOKWidgetSelected();
				}
			}
		});
		// Keep the splash screen visible and prevent the RCP application from 
		// loading until the close button is clicked.
		doEventLoop();
	}
	
	/**
	 * 
	 */
	private void doEventLoop() {
		Shell splash = getSplash();
		while (fAuthenticated == false) {
			if (splash.getDisplay().readAndDispatch() == false) {
				splash.getDisplay().sleep();
			}
		}
	}

	/**
	 * 
	 */
	private void createUIListeners() {
		// Create the OK button listeners
		createUIListenersButtonOK();
		// Create the cancel button listeners
		createUIListenersButtonCancel();
	}

	/**
	 * 
	 */
	private void createUIListenersButtonCancel() {
		if (fButtonCancel != null) {
			fButtonCancel.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					handleButtonCancelWidgetSelected();
				}
			});	
		}
	}

	/**
	 * 
	 */
	private void handleButtonCancelWidgetSelected() {
		// Abort the loading of the RCP application
		getSplash().getDisplay().close();
		System.exit(0);		
	}
	
	/**
	 * 
	 */
	private void createUIListenersButtonOK() {
		if (fButtonOK != null) {
			fButtonOK.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					handleButtonOKWidgetSelected();
				}
			});		
		}
	}

	/**
	 * 
	 */
	private void handleButtonOKWidgetSelected() {
		String serverUrl = fTextServerUrl.getText();
		String mandant = fTextMandant.getText();
		String username = fTextUsername.getText();
		String password = fTextPassword.getText();
		// Authentication is successful if a user provides any username and
		// any password
		if ((serverUrl.length() > 0) && (mandant.length() > 0) && (username.length() > 0) &&
				(password.length() > 0)) {
			// Try to authenticate.
			fAuthenticated = login(serverUrl, mandant, username, password);
			if (!fAuthenticated) {
				MessageDialog.openError(getSplash(), "Authentication failed!", "Authentication failed!");
			}
		} 
	}

	private boolean login(final String serverUrl, final String mandant, final String username, final String password) {
		try {
			if (AuthenticationUtil.getEimInterfaceAndAuthenticate(serverUrl, mandant,
					username, password) == null) {
				MessageDialog
						.openWarning(
								getSplash(),
								"No Server Url specified!",
								"No Server Url has been specified. Only limited functionality available! Please specify a valid server url.");
			}
			return true;
		} catch (Exception e1) {
			return false;
		}
	}
	
	/**
	 * 
	 */
	private void createUI() {
		String serverUrl = PlatformUI.getPreferenceStore().getString(PreferenceConstants.OPEN_SERVER_URL);
		String mandant = PlatformUI.getPreferenceStore().getString(PreferenceConstants.MANDANT);
		String username = PlatformUI.getPreferenceStore().getString(PreferenceConstants.USERNAME);
		String password = PlatformUI.getPreferenceStore().getString(PreferenceConstants.PASSWORD);
		if (password != null && !password.isEmpty()) {
			byte[] passwordBytes = null;
			try {
				passwordBytes = EncryptionUtil.decrypt(password.getBytes(), EncryptionUtil.KEY);
			} catch (Exception e) {
				// nothing to do -> causes the test field to be empty
			}
			password = "";
			if (passwordBytes != null) {
				password = new String(passwordBytes);
			}
		}
		if (mandant != null && !mandant.isEmpty() && username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
			fAuthenticated = login(serverUrl, mandant, username, password);
		}
		if (!fAuthenticated) {
			// Create the login panel
			createUICompositeLogin();
			// Create the blank spanner
			createUICompositeBlank();
			// Create the user name label
			createUILabelServerUrl();
			// Create the user name text widget
			createUITextServerUrl();
			// Create the user name label
			createUILabelMandant();
			// Create the user name text widget
			createUITextMandant();
			// Create the user name label
			createUILabelUserName();
			// Create the user name text widget
			createUITextUserName();
			// Create the password label
			createUILabelPassword();
			// Create the password text widget
			createUITextPassword();
			// Create the blank label
			createUILabelBlank();
			// Create the OK button
			createUIButtonOK();
			// Create the cancel button
			createUIButtonCancel();
		}
	}		
	
	/**
	 * 
	 */
	private void createUIButtonCancel() {
		// Create the button
		fButtonCancel = new Button(fCompositeLogin, SWT.PUSH);
		fButtonCancel.setText("Cancel"); //$NON-NLS-1$
		// Configure layout data
		GridData data = new GridData(SWT.NONE, SWT.NONE, false, false);
		data.widthHint = F_BUTTON_WIDTH_HINT;	
		data.verticalIndent = 10;
		fButtonCancel.setLayoutData(data);
	}

	/**
	 * 
	 */
	private void createUIButtonOK() {
		// Create the button
		fButtonOK = new Button(fCompositeLogin, SWT.PUSH);
		fButtonOK.setText("OK"); //$NON-NLS-1$
		// Configure layout data
		GridData data = new GridData(SWT.NONE, SWT.NONE, false, false);
		data.widthHint = F_BUTTON_WIDTH_HINT;
		data.verticalIndent = 10;
		fButtonOK.setLayoutData(data);
	}

	/**
	 * 
	 */
	private void createUILabelBlank() {
		Label label = new Label(fCompositeLogin, SWT.NONE);
		label.setVisible(false);
	}

	/**
	 * 
	 */
	private void createUITextPassword() {
		// Create the text widget
		int style = SWT.PASSWORD | SWT.BORDER;
		fTextPassword = new Text(fCompositeLogin, style);
		// Configure layout data
		GridData data = new GridData(SWT.NONE, SWT.NONE, false, false);
		data.widthHint = F_TEXT_WIDTH_HINT;
		data.horizontalSpan = 2;
		fTextPassword.setLayoutData(data);	
		String password = PlatformUI.getPreferenceStore().getString(PreferenceConstants.PASSWORD);
		if (password != null && !password.isEmpty()) {
			byte[] passwordBytes = null;
			try {
				passwordBytes = EncryptionUtil.decrypt(password.getBytes(), EncryptionUtil.KEY);
			} catch (Exception e) {
				// nothing to do -> causes the test field to be empty
			}
			String passwordString = "";
			if (passwordBytes != null) {
				passwordString = new String(passwordBytes);
			}
			fTextPassword.setText(passwordString);
		}
	}

	/**
	 * 
	 */
	private void createUILabelPassword() {
		// Create the label
		Label label = new Label(fCompositeLogin, SWT.NONE);
		label.setText("&Password:"); //$NON-NLS-1$
		// Configure layout data
		GridData data = new GridData();
		data.horizontalIndent = F_LABEL_HORIZONTAL_INDENT;
		label.setLayoutData(data);					
	}

	/**
	 * 
	 */
	private void createUITextUserName() {
		// Create the text widget
		fTextUsername = new Text(fCompositeLogin, SWT.BORDER);
		// Configure layout data
		GridData data = new GridData(SWT.NONE, SWT.NONE, false, false);
		data.widthHint = F_TEXT_WIDTH_HINT;
		data.horizontalSpan = 2;
		fTextUsername.setLayoutData(data);
		String userName = PlatformUI.getPreferenceStore().getString(PreferenceConstants.USERNAME);
		if (userName != null && !userName.isEmpty()) {
			fTextUsername.setText(userName);
		}
	}

	/**
	 * 
	 */
	private void createUILabelUserName() {
		// Create the label
		Label label = new Label(fCompositeLogin, SWT.NONE);
		label.setText("&User Name:"); //$NON-NLS-1$
		// Configure layout data
		GridData data = new GridData();
		data.horizontalIndent = F_LABEL_HORIZONTAL_INDENT;
		label.setLayoutData(data);		
	}
	
	/**
	 * 
	 */
	private void createUITextMandant() {
		// Create the text widget
		fTextMandant = new Text(fCompositeLogin, SWT.BORDER);
		// Configure layout data
		GridData data = new GridData(SWT.NONE, SWT.NONE, false, false);
		data.widthHint = F_TEXT_WIDTH_HINT;
		data.horizontalSpan = 2;
		fTextMandant.setLayoutData(data);
		String mandant = PlatformUI.getPreferenceStore().getString(PreferenceConstants.MANDANT);
		if (mandant != null && !mandant.isEmpty()) {
			fTextMandant.setText(mandant);
		}
	}

	/**
	 * 
	 */
	private void createUILabelMandant() {
		// Create the label
		Label label = new Label(fCompositeLogin, SWT.NONE);
		label.setText("Mandant:"); //$NON-NLS-1$
		// Configure layout data
		GridData data = new GridData();
		data.horizontalIndent = F_LABEL_HORIZONTAL_INDENT;
		label.setLayoutData(data);		
	}

	/**
	 * 
	 */
	private void createUITextServerUrl() {
		// Create the text widget
		fTextServerUrl = new Text(fCompositeLogin, SWT.BORDER);
		// Configure layout data
		GridData data = new GridData(SWT.NONE, SWT.NONE, false, false);
		data.widthHint = F_TEXT_WIDTH_HINT;
		data.horizontalSpan = 2;
		fTextServerUrl.setLayoutData(data);
		String serverUrl = PlatformUI.getPreferenceStore().getString(PreferenceConstants.OPEN_SERVER_URL);
		if (serverUrl != null && !serverUrl.isEmpty()) {
			fTextServerUrl.setText(serverUrl);
		}
	}

	/**
	 * 
	 */
	private void createUILabelServerUrl() {
		// Create the label
		Label label = new Label(fCompositeLogin, SWT.NONE);
		label.setText("Server URL:"); //$NON-NLS-1$
		// Configure layout data
		GridData data = new GridData();
		data.horizontalIndent = F_LABEL_HORIZONTAL_INDENT;
		label.setLayoutData(data);		
	}
	
	/**
	 * 
	 */
	private void createUICompositeBlank() {
		Composite spanner = new Composite(fCompositeLogin, SWT.NONE);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.horizontalSpan = F_COLUMN_COUNT;
		spanner.setLayoutData(data);
	}

	/**
	 * 
	 */
	private void createUICompositeLogin() {
		// Create the composite
		fCompositeLogin = new Composite(getSplash(), SWT.BORDER);
		GridLayout layout = new GridLayout(F_COLUMN_COUNT, false);
		fCompositeLogin.setLayout(layout);		
	}

	/**
	 * 
	 */
	private void configureUISplash() {
		// Configure layout
		FillLayout layout = new FillLayout(); 
		getSplash().setLayout(layout);
		// Force shell to inherit the splash background
		getSplash().setBackgroundMode(SWT.INHERIT_DEFAULT);
	}
	
}
