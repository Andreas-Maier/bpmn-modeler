package org.eclipse.bpmn2.modeler.core.builder;

import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.bpmn2.modeler.core.validation.BPMN2ProjectValidator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class BPMN2Builder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "org.eclipse.bpmn2.modeler.core.bpmn2Builder";
	private static final String MARKER_TYPE = "org.eclipse.bpmn2.modeler.core.xmlProblem";
	private SAXParserFactory parserFactory;

	
	class BPMN2DeltaVisitor implements IResourceDeltaVisitor {
		IProgressMonitor monitor;
		
		public BPMN2DeltaVisitor(IProgressMonitor monitor) {
			this.monitor = monitor;
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
		 */
		public boolean visit(IResourceDelta delta) throws CoreException {
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
//				checkXML(resource);
				validate(delta, monitor);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
//				checkXML(resource);
				validate(delta, monitor);
				break;
			}
			//return true to continue visiting children.
			return true;
		}
	}

	class BPMN2ResourceVisitor implements IResourceVisitor {
		IProgressMonitor monitor;
		
		public BPMN2ResourceVisitor(IProgressMonitor monitor) {
			this.monitor = monitor;
		}
		
		public boolean visit(IResource resource) {
//			checkXML(resource);
			validate(resource, monitor);
			//return true to continue visiting children.
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 *      java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
			throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new BPMN2DeltaVisitor(monitor));
	}

	void validate(IResourceDelta delta, IProgressMonitor monitor) {
		BPMN2ProjectValidator.validate(delta, monitor);
	}

	void validate(IResource resource, IProgressMonitor monitor) {
		BPMN2ProjectValidator.validate(resource, monitor);
	}

	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		try {
			getProject().accept(new BPMN2ResourceVisitor(monitor));
		} catch (CoreException e) {
		}
	}

	/**
	 * This was generated by the Project Builder/Nature wizard. No longer used, but keeping
	 * this around just in case...
	 * 
	 * @deprecated
	 */
	private class XMLErrorHandler extends DefaultHandler {
		
		private IFile file;

		public XMLErrorHandler(IFile file) {
			this.file = file;
		}

		private void addMarker(SAXParseException e, int severity) {
			BPMN2Builder.this.addMarker(file, e.getMessage(), e
					.getLineNumber(), severity);
		}

		public void error(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_ERROR);
		}

		public void fatalError(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_ERROR);
		}

		public void warning(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_WARNING);
		}
	}

	/**
	 * @param file
	 * @param message
	 * @param lineNumber
	 * @param severity
	 * @deprecated
	 */
	private void addMarker(IFile file, String message, int lineNumber,
			int severity) {
		try {
			IMarker marker = file.createMarker(MARKER_TYPE);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			if (lineNumber == -1) {
				lineNumber = 1;
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
		} catch (CoreException e) {
		}
	}

	/**
	 * @param resource
	 * @deprecated
	 */
	void checkXML(IResource resource) {
		if (BPMN2ProjectValidator.isBPMN2File(resource)) {
			IFile file = (IFile) resource;
			deleteMarkers(file);
			XMLErrorHandler reporter = new XMLErrorHandler(file);
			try {
				getParser().parse(file.getContents(), reporter);
			} catch (Exception e1) {
			}
		}
	}

	/**
	 * @param file
	 * @deprecated
	 */
	private void deleteMarkers(IFile file) {
		try {
			file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
		} catch (CoreException ce) {
		}
	}

	/**
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @deprecated
	 */
	private SAXParser getParser() throws ParserConfigurationException,
			SAXException {
		if (parserFactory == null) {
			parserFactory = SAXParserFactory.newInstance();
		}
		return parserFactory.newSAXParser();
	}
}