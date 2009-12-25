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
package org.eclipse.egf.model.domain;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.domain.DomainFactory
 * @model kind="package"
 * @generated
 */
public interface DomainPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "domain"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/domain"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "domain"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DomainPackage eINSTANCE = org.eclipse.egf.model.domain.impl.DomainPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.DomainViewpointImpl <em>Viewpoint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.domain.impl.DomainViewpointImpl
   * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainViewpoint()
   * @generated
   */
  int DOMAIN_VIEWPOINT = 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT__ID = FcorePackage.VIEWPOINT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT__NAME = FcorePackage.VIEWPOINT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT__DESCRIPTION = FcorePackage.VIEWPOINT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Viewerpoint Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT__VIEWERPOINT_CONTAINER = FcorePackage.VIEWPOINT__VIEWERPOINT_CONTAINER;

  /**
   * The feature id for the '<em><b>Domains</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT__DOMAINS = FcorePackage.VIEWPOINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Viewpoint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_VIEWPOINT_FEATURE_COUNT = FcorePackage.VIEWPOINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.DomainImpl <em>Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.domain.impl.DomainImpl
   * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomain()
   * @generated
   */
  int DOMAIN = 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__ID = FcorePackage.MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__NAME = FcorePackage.MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__DESCRIPTION = FcorePackage.MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Epackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__EPACKAGE = FcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_FEATURE_COUNT = FcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.domain.impl.DomainTypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.domain.impl.DomainTypeImpl
   * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainType()
   * @generated
   */
  int DOMAIN_TYPE = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_TYPE__ID = FcorePackage.TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_TYPE__NAME = FcorePackage.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_TYPE__DESCRIPTION = FcorePackage.TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Domain</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_TYPE__DOMAIN = FcorePackage.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_TYPE_FEATURE_COUNT = FcorePackage.TYPE_FEATURE_COUNT + 1;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.domain.DomainViewpoint <em>Viewpoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Viewpoint</em>'.
   * @see org.eclipse.egf.model.domain.DomainViewpoint
   * @generated
   */
  EClass getDomainViewpoint();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.domain.DomainViewpoint#getDomains <em>Domains</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Domains</em>'.
   * @see org.eclipse.egf.model.domain.DomainViewpoint#getDomains()
   * @see #getDomainViewpoint()
   * @generated
   */
  EReference getDomainViewpoint_Domains();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.domain.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain</em>'.
   * @see org.eclipse.egf.model.domain.Domain
   * @generated
   */
  EClass getDomain();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.Domain#getEpackage <em>Epackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Epackage</em>'.
   * @see org.eclipse.egf.model.domain.Domain#getEpackage()
   * @see #getDomain()
   * @generated
   */
  EReference getDomain_Epackage();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.domain.DomainType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.eclipse.egf.model.domain.DomainType
   * @generated
   */
  EClass getDomainType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.domain.DomainType#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Domain</em>'.
   * @see org.eclipse.egf.model.domain.DomainType#getDomain()
   * @see #getDomainType()
   * @generated
   */
  EReference getDomainType_Domain();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DomainFactory getDomainFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainViewpointImpl <em>Viewpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.DomainViewpointImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainViewpoint()
     * @generated
     */
    EClass DOMAIN_VIEWPOINT = eINSTANCE.getDomainViewpoint();

    /**
     * The meta object literal for the '<em><b>Domains</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_VIEWPOINT__DOMAINS = eINSTANCE.getDomainViewpoint_Domains();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainImpl <em>Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.DomainImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomain()
     * @generated
     */
    EClass DOMAIN = eINSTANCE.getDomain();

    /**
     * The meta object literal for the '<em><b>Epackage</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN__EPACKAGE = eINSTANCE.getDomain_Epackage();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.domain.impl.DomainTypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.domain.impl.DomainTypeImpl
     * @see org.eclipse.egf.model.domain.impl.DomainPackageImpl#getDomainType()
     * @generated
     */
    EClass DOMAIN_TYPE = eINSTANCE.getDomainType();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_TYPE__DOMAIN = eINSTANCE.getDomainType_Domain();

  }

} // DomainPackage
