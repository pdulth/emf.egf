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
package org.eclipse.egf.model.fcore.impl;

import org.eclipse.egf.common.helper.IDGeneratorHelper;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ModelElementImpl#getID <em>ID</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ModelElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ModelElementImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ModelElementImpl extends Container implements ModelElement {
  /**
   * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected int eFlags = 0;

  /**
   * The default value of the '{@link #getID() <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getID()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getID()
   * @generated
   * @ordered
   */
  protected String iD = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.MODEL_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public String getID() {
    if (iD == null) {
      iD = IDGeneratorHelper.generateUID(this);
    }
    return iD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void setIDGen(String newID) {
    String oldID = iD;
    iD = newID;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.MODEL_ELEMENT__ID, oldID, iD));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void setID(String newID) {
    Resource eResource = eResource();
    if (eResource instanceof ResourceImpl) {
      ((ResourceImpl) eResource).getIntrinsicIDToEObjectMap().clear();
    }
    setIDGen(newID);
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
  public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.MODEL_ELEMENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.MODEL_ELEMENT__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public String getExternalName() {
    return getName() != null && getName().trim().length() != 0 ? getName() : getID();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FcorePackage.MODEL_ELEMENT__ID:
      return getID();
    case FcorePackage.MODEL_ELEMENT__NAME:
      return getName();
    case FcorePackage.MODEL_ELEMENT__DESCRIPTION:
      return getDescription();
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
    case FcorePackage.MODEL_ELEMENT__ID:
      setID((String) newValue);
      return;
    case FcorePackage.MODEL_ELEMENT__NAME:
      setName((String) newValue);
      return;
    case FcorePackage.MODEL_ELEMENT__DESCRIPTION:
      setDescription((String) newValue);
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
    case FcorePackage.MODEL_ELEMENT__ID:
      setID(ID_EDEFAULT);
      return;
    case FcorePackage.MODEL_ELEMENT__NAME:
      setName(NAME_EDEFAULT);
      return;
    case FcorePackage.MODEL_ELEMENT__DESCRIPTION:
      setDescription(DESCRIPTION_EDEFAULT);
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
    case FcorePackage.MODEL_ELEMENT__ID:
      return ID_EDEFAULT == null ? iD != null : !ID_EDEFAULT.equals(iD);
    case FcorePackage.MODEL_ELEMENT__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case FcorePackage.MODEL_ELEMENT__DESCRIPTION:
      return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (iD: "); //$NON-NLS-1$
    result.append(iD);
    result.append(", name: "); //$NON-NLS-1$
    result.append(name);
    result.append(", description: "); //$NON-NLS-1$
    result.append(description);
    result.append(')');
    return result.toString();
  }

} // ModelElementImpl
