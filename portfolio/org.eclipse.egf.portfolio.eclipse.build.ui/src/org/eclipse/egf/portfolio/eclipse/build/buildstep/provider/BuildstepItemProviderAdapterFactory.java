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

package org.eclipse.egf.portfolio.eclipse.build.buildstep.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.util.BuildcoreSwitch;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepFactory;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.util.BuildstepAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.command.CommandParameter;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BuildstepItemProviderAdapterFactory extends BuildstepAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This helps manage the child creation extenders.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(BuildStepEditPlugin.INSTANCE, BuildstepPackage.eNS_URI);

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildstepItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CleanStepItemProvider cleanStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createCleanStepAdapter() {
        if (cleanStepItemProvider == null) {
            cleanStepItemProvider = new CleanStepItemProvider(this);
        }

        return cleanStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BuildStepItemProvider buildStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createBuildStepAdapter() {
        if (buildStepItemProvider == null) {
            buildStepItemProvider = new BuildStepItemProvider(this);
        }

        return buildStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PublishStepItemProvider publishStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createPublishStepAdapter() {
        if (publishStepItemProvider == null) {
            publishStepItemProvider = new PublishStepItemProvider(this);
        }

        return publishStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TestStepItemProvider testStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTestStepAdapter() {
        if (testStepItemProvider == null) {
            testStepItemProvider = new TestStepItemProvider(this);
        }

        return testStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AntStepItemProvider antStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createAntStepAdapter() {
        if (antStepItemProvider == null) {
            antStepItemProvider = new AntStepItemProvider(this);
        }

        return antStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JavadocStepItemProvider javadocStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createJavadocStepAdapter() {
        if (javadocStepItemProvider == null) {
            javadocStepItemProvider = new JavadocStepItemProvider(this);
        }

        return javadocStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EgfStepItemProvider egfStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createEgfStepAdapter() {
        if (egfStepItemProvider == null) {
            egfStepItemProvider = new EgfStepItemProvider(this);
        }

        return egfStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EgfActivityItemProvider egfActivityItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createEgfActivityAdapter() {
        if (egfActivityItemProvider == null) {
            egfActivityItemProvider = new EgfActivityItemProvider(this);
        }

        return egfActivityItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AggregateStepItemProvider aggregateStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createAggregateStepAdapter() {
        if (aggregateStepItemProvider == null) {
            aggregateStepItemProvider = new AggregateStepItemProvider(this);
        }

        return aggregateStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InstallStepItemProvider installStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createInstallStepAdapter() {
        if (installStepItemProvider == null) {
            installStepItemProvider = new InstallStepItemProvider(this);
        }

        return installStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LocalBuildLocationItemProvider localBuildLocationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createLocalBuildLocationAdapter() {
        if (localBuildLocationItemProvider == null) {
            localBuildLocationItemProvider = new LocalBuildLocationItemProvider(this);
        }

        return localBuildLocationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TargetPlatformBuildLocation} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TargetPlatformBuildLocationItemProvider targetPlatformBuildLocationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TargetPlatformBuildLocation}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTargetPlatformBuildLocationAdapter() {
        if (targetPlatformBuildLocationItemProvider == null) {
            targetPlatformBuildLocationItemProvider = new TargetPlatformBuildLocationItemProvider(this);
        }

        return targetPlatformBuildLocationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UpdateSiteBuildLocationItemProvider updateSiteBuildLocationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createUpdateSiteBuildLocationAdapter() {
        if (updateSiteBuildLocationItemProvider == null) {
            updateSiteBuildLocationItemProvider = new UpdateSiteBuildLocationItemProvider(this);
        }

        return updateSiteBuildLocationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ResultStepBuildLocationItemProvider resultStepBuildLocationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createResultStepBuildLocationAdapter() {
        if (resultStepBuildLocationItemProvider == null) {
            resultStepBuildLocationItemProvider = new ResultStepBuildLocationItemProvider(this);
        }

        return resultStepBuildLocationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InstallStepBuildLocationItemProvider installStepBuildLocationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createInstallStepBuildLocationAdapter() {
        if (installStepBuildLocationItemProvider == null) {
            installStepBuildLocationItemProvider = new InstallStepBuildLocationItemProvider(this);
        }

        return installStepBuildLocationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.RunningPlatformBuildLocation} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RunningPlatformBuildLocationItemProvider runningPlatformBuildLocationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.RunningPlatformBuildLocation}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createRunningPlatformBuildLocationAdapter() {
        if (runningPlatformBuildLocationItemProvider == null) {
            runningPlatformBuildLocationItemProvider = new RunningPlatformBuildLocationItemProvider(this);
        }

        return runningPlatformBuildLocationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Plugin} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PluginItemProvider pluginItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Plugin}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createPluginAdapter() {
        if (pluginItemProvider == null) {
            pluginItemProvider = new PluginItemProvider(this);
        }

        return pluginItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FeatureItemProvider featureItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createFeatureAdapter() {
        if (featureItemProvider == null) {
            featureItemProvider = new FeatureItemProvider(this);
        }

        return featureItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public List<IChildCreationExtender> getChildCreationExtenders() {
        return childCreationExtenderManager.getChildCreationExtenders();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
        return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceLocator getResourceLocator() {
        return childCreationExtenderManager;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void dispose() {
        if (cleanStepItemProvider != null) cleanStepItemProvider.dispose();
        if (buildStepItemProvider != null) buildStepItemProvider.dispose();
        if (publishStepItemProvider != null) publishStepItemProvider.dispose();
        if (testStepItemProvider != null) testStepItemProvider.dispose();
        if (antStepItemProvider != null) antStepItemProvider.dispose();
        if (javadocStepItemProvider != null) javadocStepItemProvider.dispose();
        if (egfStepItemProvider != null) egfStepItemProvider.dispose();
        if (egfActivityItemProvider != null) egfActivityItemProvider.dispose();
        if (aggregateStepItemProvider != null) aggregateStepItemProvider.dispose();
        if (installStepItemProvider != null) installStepItemProvider.dispose();
        if (localBuildLocationItemProvider != null) localBuildLocationItemProvider.dispose();
        if (targetPlatformBuildLocationItemProvider != null) targetPlatformBuildLocationItemProvider.dispose();
        if (updateSiteBuildLocationItemProvider != null) updateSiteBuildLocationItemProvider.dispose();
        if (resultStepBuildLocationItemProvider != null) resultStepBuildLocationItemProvider.dispose();
        if (installStepBuildLocationItemProvider != null) installStepBuildLocationItemProvider.dispose();
        if (runningPlatformBuildLocationItemProvider != null) runningPlatformBuildLocationItemProvider.dispose();
        if (pluginItemProvider != null) pluginItemProvider.dispose();
        if (featureItemProvider != null) featureItemProvider.dispose();
    }

    /**
     * A child creation extender for the {@link BuildcorePackage}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static class BuildcoreChildCreationExtender implements IChildCreationExtender {
        /**
         * The switch for creating child descriptors specific to each extended class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected static class CreationSwitch extends BuildcoreSwitch<Object> {
            /**
             * The child descriptors being populated.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected List<Object> newChildDescriptors;

            /**
             * The domain in which to create the children.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected EditingDomain editingDomain;

            /**
             * Creates the a switch for populating child descriptors in the given domain.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
                this.newChildDescriptors = newChildDescriptors;
                this.editingDomain = editingDomain;
            }
            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            @Override
            public Object caseJob(Job object) {


        newChildDescriptors.add
            (createChildParameter
                (BuildcorePackage.Literals.JOB__STEPS,
                 BuildstepFactory.eINSTANCE.createCleanStep()));





        newChildDescriptors.add
            (createChildParameter
                (BuildcorePackage.Literals.JOB__STEPS,
                 BuildstepFactory.eINSTANCE.createBuildStep()));





        newChildDescriptors.add
            (createChildParameter
                (BuildcorePackage.Literals.JOB__STEPS,
                 BuildstepFactory.eINSTANCE.createPublishStep()));





        newChildDescriptors.add
            (createChildParameter
                (BuildcorePackage.Literals.JOB__STEPS,
                 BuildstepFactory.eINSTANCE.createTestStep()));





        newChildDescriptors.add
            (createChildParameter
                (BuildcorePackage.Literals.JOB__STEPS,
                 BuildstepFactory.eINSTANCE.createAntStep()));



        newChildDescriptors.add
            (createChildParameter
                (BuildcorePackage.Literals.JOB__STEPS,
                 BuildstepFactory.eINSTANCE.createJavadocStepFilled()));




        newChildDescriptors.add
            (createChildParameter
                (BuildcorePackage.Literals.JOB__STEPS,
                 BuildstepFactory.eINSTANCE.createEgfStep()));





        newChildDescriptors.add
            (createChildParameter
                (BuildcorePackage.Literals.JOB__STEPS,
                 BuildstepFactory.eINSTANCE.createAggregateStep()));





        newChildDescriptors.add
            (createChildParameter
                (BuildcorePackage.Literals.JOB__STEPS,
                 BuildstepFactory.eINSTANCE.createInstallStep()));



                return null;
            }
 
            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected CommandParameter createChildParameter(Object feature, Object child) {
                return new CommandParameter(null, feature, child);
            }

        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
            ArrayList<Object> result = new ArrayList<Object>();
           new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
           return result;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public ResourceLocator getResourceLocator() {
            return BuildStepEditPlugin.INSTANCE;
        }
    }

}
