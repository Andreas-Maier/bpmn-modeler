/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.casOpen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Condition Comparators</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.camunda.bpm.modeler.runtime.engine.model.casOpen.CasOpenPackage#getConditionComparators()
 * @model
 * @generated
 */
public enum ConditionComparators implements Enumerator {
	/**
	 * The '<em><b>EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	EQUAL(0, "EQUAL", "=="),

	/**
	 * The '<em><b>NOT EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_EQUAL(1, "NOT_EQUAL", "!="),

	/**
	 * The '<em><b>GREATER EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER_EQUAL(2, "GREATER_EQUAL", ">="),

	/**
	 * The '<em><b>GREATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER(3, "GREATER", ">"),

	/**
	 * The '<em><b>LOWER EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_EQUAL(4, "LOWER_EQUAL", "<="),

	/**
	 * The '<em><b>LOWER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER(5, "LOWER", "<");

	/**
	 * The '<em><b>EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUAL
	 * @model literal="=="
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL_VALUE = 0;

	/**
	 * The '<em><b>NOT EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUAL
	 * @model literal="!="
	 * @generated
	 * @ordered
	 */
	public static final int NOT_EQUAL_VALUE = 1;

	/**
	 * The '<em><b>GREATER EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATER EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER_EQUAL
	 * @model literal=">="
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_EQUAL_VALUE = 2;

	/**
	 * The '<em><b>GREATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER
	 * @model literal=">"
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_VALUE = 3;

	/**
	 * The '<em><b>LOWER EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOWER EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER_EQUAL
	 * @model literal="<="
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_EQUAL_VALUE = 4;

	/**
	 * The '<em><b>LOWER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOWER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER
	 * @model literal="<"
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_VALUE = 5;

	/**
	 * An array of all the '<em><b>Condition Comparators</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ConditionComparators[] VALUES_ARRAY =
		new ConditionComparators[] {
			EQUAL,
			NOT_EQUAL,
			GREATER_EQUAL,
			GREATER,
			LOWER_EQUAL,
			LOWER,
		};

	/**
	 * A public read-only list of all the '<em><b>Condition Comparators</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ConditionComparators> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Condition Comparators</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConditionComparators get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConditionComparators result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Condition Comparators</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConditionComparators getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConditionComparators result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Condition Comparators</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConditionComparators get(int value) {
		switch (value) {
			case EQUAL_VALUE: return EQUAL;
			case NOT_EQUAL_VALUE: return NOT_EQUAL;
			case GREATER_EQUAL_VALUE: return GREATER_EQUAL;
			case GREATER_VALUE: return GREATER;
			case LOWER_EQUAL_VALUE: return LOWER_EQUAL;
			case LOWER_VALUE: return LOWER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ConditionComparators(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ConditionComparators
