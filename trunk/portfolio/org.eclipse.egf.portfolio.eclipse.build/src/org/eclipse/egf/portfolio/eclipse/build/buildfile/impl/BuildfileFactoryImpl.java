/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildfile.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildfile.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuildfileFactoryImpl extends EFactoryImpl implements BuildfileFactory {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static BuildfileFactory init() {
        try {
            BuildfileFactory theBuildfileFactory = (BuildfileFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/buildfile"); 
            if (theBuildfileFactory != null) {
                return theBuildfileFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new BuildfileFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildfileFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case BuildfilePackage.ANT_PARAMETER: return createAntParameter();
            case BuildfilePackage.ZIP_STEP: return createZipStep();
            case BuildfilePackage.UNZIP_STEP: return createUnzipStep();
            case BuildfilePackage.MOVE_STEP: return createMoveStep();
            case BuildfilePackage.RENAME_STEP: return createRenameStep();
            case BuildfilePackage.DELETE_STEP: return createDeleteStep();
            case BuildfilePackage.COPY_STEP: return createCopyStep();
            case BuildfilePackage.DOWNLOAD_STEP: return createDownloadStep();
            case BuildfilePackage.CREATE_FOLDER_STEP: return createCreateFolderStep();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AntParameter createAntParameter() {
        AntParameterImpl antParameter = new AntParameterImpl();
        return antParameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ZipStep createZipStep() {
        ZipStepImpl zipStep = new ZipStepImpl();
        return zipStep;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UnzipStep createUnzipStep() {
        UnzipStepImpl unzipStep = new UnzipStepImpl();
        return unzipStep;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MoveStep createMoveStep() {
        MoveStepImpl moveStep = new MoveStepImpl();
        return moveStep;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RenameStep createRenameStep() {
        RenameStepImpl renameStep = new RenameStepImpl();
        return renameStep;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DeleteStep createDeleteStep() {
        DeleteStepImpl deleteStep = new DeleteStepImpl();
        return deleteStep;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CopyStep createCopyStep() {
        CopyStepImpl copyStep = new CopyStepImpl();
        return copyStep;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DownloadStep createDownloadStep() {
        DownloadStepImpl downloadStep = new DownloadStepImpl();
        return downloadStep;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CreateFolderStep createCreateFolderStep() {
        CreateFolderStepImpl createFolderStep = new CreateFolderStepImpl();
        return createFolderStep;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildfilePackage getBuildfilePackage() {
        return (BuildfilePackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static BuildfilePackage getPackage() {
        return BuildfilePackage.eINSTANCE;
    }

} //BuildfileFactoryImpl
