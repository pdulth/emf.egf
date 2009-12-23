/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.productionplan.impl;

import org.eclipse.egf.model.factorycomponent.impl.InvocationImpl;

import org.eclipse.egf.model.productionplan.ProductionPlan;
import org.eclipse.egf.model.productionplan.ProductionPlanInvocation;
import org.eclipse.egf.model.productionplan.ProductionPlanPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.productionplan.impl.ProductionPlanInvocationImpl#getProductionPlan <em>Production Plan</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ProductionPlanInvocationImpl extends InvocationImpl implements ProductionPlanInvocation {
  /**
   * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected int eFlags = 0;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProductionPlanInvocationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ProductionPlanPackage.Literals.PRODUCTION_PLAN_INVOCATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProductionPlan getProductionPlan() {
    if (eContainerFeatureID() != ProductionPlanPackage.PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN)
      return null;
    return (ProductionPlan) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProductionPlan(ProductionPlan newProductionPlan, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newProductionPlan, ProductionPlanPackage.PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProductionPlan(ProductionPlan newProductionPlan) {
    if (newProductionPlan != eInternalContainer()
        || (eContainerFeatureID() != ProductionPlanPackage.PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN && newProductionPlan != null)) {
      if (EcoreUtil.isAncestor(this, newProductionPlan))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newProductionPlan != null)
        msgs = ((InternalEObject) newProductionPlan).eInverseAdd(this, ProductionPlanPackage.PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS,
            ProductionPlan.class, msgs);
      msgs = basicSetProductionPlan(newProductionPlan, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductionPlanPackage.PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN,
          newProductionPlan, newProductionPlan));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case ProductionPlanPackage.PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetProductionPlan((ProductionPlan) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case ProductionPlanPackage.PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN:
      return basicSetProductionPlan(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
    case ProductionPlanPackage.PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN:
      return eInternalContainer().eInverseRemove(this, ProductionPlanPackage.PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS,
          ProductionPlan.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ProductionPlanPackage.PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN:
      return getProductionPlan();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ProductionPlanPackage.PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN:
      setProductionPlan((ProductionPlan) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case ProductionPlanPackage.PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN:
      setProductionPlan((ProductionPlan) null);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ProductionPlanPackage.PRODUCTION_PLAN_INVOCATION__PRODUCTION_PLAN:
      return getProductionPlan() != null;
    }
    return super.eIsSet(featureID);
  }

} //ProductionPlanInvocationImpl
