/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.fprod.util;

import java.util.List;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ActivityContractContainer;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Orchestration;

import org.eclipse.egf.model.fprod.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.fprod.FprodPackage
 * @generated
 */
public class FprodSwitch<T1> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FprodPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FprodSwitch() {
    if (modelPackage == null) {
      modelPackage = FprodPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T1 doSwitch(EObject theEObject) {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T1 doSwitch(EClass theEClass, EObject theEObject) {
    if (theEClass.eContainer() == modelPackage) {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    } else {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T1 doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
    case FprodPackage.PRODUCTION_PLAN: {
      ProductionPlan productionPlan = (ProductionPlan) theEObject;
      T1 result = caseProductionPlan(productionPlan);
      if (result == null)
        result = caseOrchestration(productionPlan);
      if (result == null)
        result = caseModelElement(productionPlan);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FprodPackage.PRODUCTION_PLAN_INVOCATION: {
      ProductionPlanInvocation<?> productionPlanInvocation = (ProductionPlanInvocation<?>) theEObject;
      T1 result = caseProductionPlanInvocation(productionPlanInvocation);
      if (result == null)
        result = caseInvocation(productionPlanInvocation);
      if (result == null)
        result = caseModelElement(productionPlanInvocation);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FprodPackage.FACTORY_COMPONENT_INVOCATION: {
      FactoryComponentInvocation factoryComponentInvocation = (FactoryComponentInvocation) theEObject;
      T1 result = caseFactoryComponentInvocation(factoryComponentInvocation);
      if (result == null)
        result = caseProductionPlanInvocation(factoryComponentInvocation);
      if (result == null)
        result = caseInvocation(factoryComponentInvocation);
      if (result == null)
        result = caseModelElement(factoryComponentInvocation);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FprodPackage.TASK_INVOCATION: {
      TaskInvocation taskInvocation = (TaskInvocation) theEObject;
      T1 result = caseTaskInvocation(taskInvocation);
      if (result == null)
        result = caseProductionPlanInvocation(taskInvocation);
      if (result == null)
        result = caseInvocation(taskInvocation);
      if (result == null)
        result = caseModelElement(taskInvocation);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FprodPackage.TASK: {
      Task task = (Task) theEObject;
      T1 result = caseTask(task);
      if (result == null)
        result = caseActivity(task);
      if (result == null)
        result = caseModelElement(task);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FprodPackage.TASK_CONTRACT: {
      TaskContract taskContract = (TaskContract) theEObject;
      T1 result = caseTaskContract(taskContract);
      if (result == null)
        result = caseActivityContract(taskContract);
      if (result == null)
        result = caseModelElement(taskContract);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FprodPackage.TASK_CONTRACT_CONTAINER: {
      TaskContractContainer taskContractContainer = (TaskContractContainer) theEObject;
      T1 result = caseTaskContractContainer(taskContractContainer);
      if (result == null)
        result = caseActivityContractContainer(taskContractContainer);
      if (result == null)
        result = caseModelElement(taskContractContainer);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Production Plan</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Production Plan</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseProductionPlan(ProductionPlan object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Production Plan Invocation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Production Plan Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public <T extends Activity> T1 caseProductionPlanInvocation(ProductionPlanInvocation<T> object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Factory Component Invocation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Factory Component Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseFactoryComponentInvocation(FactoryComponentInvocation object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Task Invocation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Task Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTaskInvocation(TaskInvocation object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTask(Task object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Task Contract</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Task Contract</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTaskContract(TaskContract object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Task Contract Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Task Contract Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseTaskContractContainer(TaskContractContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseModelElement(ModelElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Orchestration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Orchestration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseOrchestration(Orchestration object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invocation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public <T extends Activity> T1 caseInvocation(Invocation<T> object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseActivity(Activity object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Activity Contract</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Activity Contract</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseActivityContract(ActivityContract object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Activity Contract Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Activity Contract Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseActivityContractContainer(ActivityContractContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T1 defaultCase(EObject object) {
    return null;
  }

} //FprodSwitch
