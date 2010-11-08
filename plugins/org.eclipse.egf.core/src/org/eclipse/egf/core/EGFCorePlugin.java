/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.common.loader.IClassLoader;
import org.eclipse.egf.core.epackage.IProxyEObject;
import org.eclipse.egf.core.epackage.IProxyEPackage;
import org.eclipse.egf.core.epackage.IProxyERoot;
import org.eclipse.egf.core.epackage.ProxyTargetPlatformFactory;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.internal.genmodel.PlatformGenModel;
import org.eclipse.egf.core.internal.registry.FcoreProcessorRegistry;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformManager;
import org.eclipse.egf.core.platform.pde.ITargetPlatformManager;
import org.eclipse.egf.core.platform.uri.RuntimePlatformURIConverter;
import org.eclipse.egf.core.platform.uri.TargetPlatformURIConverter;
import org.eclipse.egf.core.processor.IFcoreProcessor;
import org.eclipse.egf.core.session.EGFBundleListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Xavier Maysonnave
 */
public class EGFCorePlugin extends EGFAbstractPlugin {

    public static String EDITING_DOMAIN_ID = "org.eclipse.egf.core.editing.domain"; //$NON-NLS-1$  

    public static String FCORE_FILE_EXTENSION = "fcore"; //$NON-NLS-1$

    /**
     * Bundle listener for debugging purposes
     */
    private static EGFBundleListener __bundleListener;

    /**
     * Keep track of the FcoreProcessorRegistry
     */
    private static FcoreProcessorRegistry __fcoreProcessorRegistry;

    /**
     * Keep track of the ERootTargetPlatformManager
     */
    private static ProxyTargetPlatformFactory __proxyTargetPlatformFactory;

    /**
     * Plug-in unique instance.
     */
    private static EGFCorePlugin __plugin;

    /**
     * Constant identifying the job family identifier for a background build job.
     * All clients
     * that schedule background jobs for performing builds should include this job
     * family in their implementation of <code>belongsTo</code>.
     * 
     * @see IJobManager#join(Object, IProgressMonitor)
     * @see Job#belongsTo(Object)
     * @since 3.0
     */
    public static final Object FAMILY_MANUAL_BUILD = new Object();

    /**
     * Get activator shared instance.
     * 
     * @return __plugin
     */
    public static EGFCorePlugin getDefault() {
        return __plugin;
    }

    /**
     * Get a target platform base ERootWrapper object based on a uri
     * 
     * @return an empty list if none could be found.
     */
    public static IProxyERoot getTargetPlatformIProxyERoot(URI uri) {
        if (__proxyTargetPlatformFactory == null) {
            __proxyTargetPlatformFactory = new ProxyTargetPlatformFactory();
        }
        return __proxyTargetPlatformFactory.getIProxyERoot(uri);
    }

    /**
     * Get a target platform base ERootWrapper object based on a uri
     * 
     * @return an empty list if none could be found.
     */
    public static IProxyERoot getTargetPlatformIProxyERoot(URI uri, Map<IPluginModelBase, IClassLoader> loaders) {
        if (__proxyTargetPlatformFactory == null) {
            __proxyTargetPlatformFactory = new ProxyTargetPlatformFactory();
        }
        return __proxyTargetPlatformFactory.getIProxyERoot(uri, loaders);
    }

    /**
     * Get a target platform base EPackageWrapper object based on a uri
     * 
     * @return an empty list if none could be found.
     */
    public static IProxyEPackage getTargetPlatformIProxyEPackage(URI uri) {
        if (__proxyTargetPlatformFactory == null) {
            __proxyTargetPlatformFactory = new ProxyTargetPlatformFactory();
        }
        return __proxyTargetPlatformFactory.getIProxyEPackage(uri);
    }

    /**
     * Get a target platform base EPackageWrapper object based on a uri
     * 
     * @return an empty list if none could be found.
     */
    public static IProxyEPackage getTargetPlatformIProxyEPackage(URI uri, Map<IPluginModelBase, IClassLoader> loaders) {
        if (__proxyTargetPlatformFactory == null) {
            __proxyTargetPlatformFactory = new ProxyTargetPlatformFactory();
        }
        return __proxyTargetPlatformFactory.getIProxyEPackage(uri, loaders);
    }

    /**
     * Get a target platform base EObjectWrapper object based on a uri
     * 
     * @return an empty list if none could be found.
     */
    public static IProxyEObject getTargetPlatformIProxyEObject(URI uri) {
        if (__proxyTargetPlatformFactory == null) {
            __proxyTargetPlatformFactory = new ProxyTargetPlatformFactory();
        }
        return __proxyTargetPlatformFactory.getIProxyEObject(uri);
    }

    /**
     * Get a target platform base EObjectWrapper object based on a uri
     * 
     * @return an empty list if none could be found.
     */
    public static IProxyEObject getTargetPlatformIProxyEObject(URI uri, Map<IPluginModelBase, IClassLoader> loaders) {
        if (__proxyTargetPlatformFactory == null) {
            __proxyTargetPlatformFactory = new ProxyTargetPlatformFactory();
        }
        return __proxyTargetPlatformFactory.getIProxyEObject(uri, loaders);
    }

    /**
     * Get fcore processor implementations.
     * 
     * @return an empty list if none could be found.
     */
    public static List<IFcoreProcessor> getFcoreProcessors() {
        if (__fcoreProcessorRegistry == null) {
            __fcoreProcessorRegistry = new FcoreProcessorRegistry();
        }
        return __fcoreProcessorRegistry.getIFcoreProcessors();
    }

    /**
     * Returns the runtime IPlatformManager singleton
     */
    public static IPlatformManager getRuntimePlatformManager() {
        return EGFPlatformPlugin.getRuntimePlatformManager();
    }

    /**
     * Returns the RuntimePlatformURIConverter singleton
     * 
     * @return an array of IPlatformFcore
     */
    public static RuntimePlatformURIConverter getRuntimePlatformURIConverter() {
        return EGFPlatformPlugin.getRuntimePlatformURIConverter();
    }

    /**
     * Returns the ITargetPlatformManager singleton
     */
    public static ITargetPlatformManager getTargetPlatformManager() {
        return EGFPlatformPlugin.getTargetPlatformManager();
    }

    /**
     * Returns the TargetPlatformURIConverter singleton
     * 
     * @return an array of IPlatformFcore
     */
    public static TargetPlatformURIConverter getTargetPlatformURIConverter() {
        return EGFPlatformPlugin.getTargetPlatformURIConverter();
    }

    /**
     * Get the IPlatformFcore for given EMF Resource.
     * 
     * @param resource
     * @return an {@link IPlatformFcore} instance or null if the
     *         resource is null or not associated with an
     *         IPlatformFcore
     */
    public static IPlatformFcore getTargetPlatformFcore(Resource resource) {
        // a URI should be absolute, otherwise we are unable to analyse its
        // first segment
        if (resource == null || resource.getURI() == null || resource.getURI().isRelative()) {
            return null;
        }
        // Project Name
        String firstSegment = resource.getURI().segment(1);
        if (firstSegment == null || firstSegment.trim().length() == 0) {
            return null;
        }
        firstSegment = firstSegment.trim();
        // locate and return the first associated IPlatformFcore
        for (IPlatformFcore fcore : EGFPlatformPlugin.getTargetPlatformManager().getPlatformExtensionPoints(firstSegment, IPlatformFcore.class)) {
            if (fcore.getURI().equals(resource.getURI())) {
                return fcore;
            }
        }
        // Nothing to retrieve
        return null;
    }

    /**
     * Get the IPlatformFcore for given EMF Resource.
     * 
     * @param resource
     * @return an {@link IPlatformFcore} instance or null if the
     *         resource is null or not associated with an
     *         IPlatformFcore
     */
    public static IPlatformFcore getRuntimePlatformFcore(Resource resource) {
        // a URI should be absolute, otherwise we are unable to analyse its
        // first segment
        if (resource == null || resource.getURI() == null || resource.getURI().isRelative()) {
            return null;
        }
        // Project Name
        String firstSegment = resource.getURI().segment(1);
        if (firstSegment == null || firstSegment.trim().length() == 0) {
            return null;
        }
        firstSegment = firstSegment.trim();
        // locate and return the first associated IPlatformFcore
        for (IPlatformFcore fcore : EGFPlatformPlugin.getRuntimePlatformManager().getPlatformExtensionPoints(firstSegment, IPlatformFcore.class)) {
            if (fcore.getURI().equals(resource.getURI())) {
                return fcore;
            }
        }
        // Nothing to retrieve
        return null;
    }

    /**
     * Get the IPlatformFcore[] for a given IPluginModelBase.
     */
    public static IPlatformFcore[] getTargetPlatformFcores(IPluginModelBase model) {
        return getTargetPlatformManager().getPlatformExtensionPoints(model, IPlatformFcore.class);
    }

    /**
     * Get the IPlatformFcore[] for a given project.
     */
    public static IPlatformFcore[] getWorkspaceTargetPlatformFcores(IProject project) {
        return getTargetPlatformManager().getPlatformExtensionPoints(project, IPlatformFcore.class);
    }

    /**
     * Returns a snapshot of known workspace IPlatformFcore
     * 
     * @return an array of IPlatformFcore
     */
    public static IPlatformFcore[] getWorkspaceTargetPlatformFcores() {
        return getTargetPlatformManager().getWorkspacePlatformExtensionPoints(IPlatformFcore.class);
    }

    /**
     * Returns a snapshot of known target IPlatformFcore
     * 
     * @return an array of IPlatformFcore
     */
    public static IPlatformFcore[] getNonWorkspaceTargetPlatformFcores() {
        return getTargetPlatformManager().getTargetPlatformExtensionPoints(IPlatformFcore.class);
    }

    /**
     * Returns a snapshot of known runtime IPlatformFcore
     * 
     * @return an array of IPlatformFcore
     */
    public static IPlatformFcore[] getRuntimePlatformFcores(Bundle bundle) {
        return getRuntimePlatformManager().getPlatformExtensionPoints(bundle.getSymbolicName(), IPlatformFcore.class);
    }

    /**
     * Returns a snapshot of known runtime IPlatformFcore
     * 
     * @return an array of IPlatformFcore
     */
    public static IPlatformFcore[] getRuntimePlatformFcores() {
        return getRuntimePlatformManager().getPlatformExtensionPoints(IPlatformFcore.class);
    }

    /**
     * Returns a snapshot of known IPlatformFcore
     * 
     * @return an array of IPlatformFcore
     */
    public static IPlatformFcore[] getTargetPlatformFcores() {
        return getTargetPlatformManager().getPlatformExtensionPoints(IPlatformFcore.class);
    }

    /**
     * Get known IPlatformGenModel[] for given project.
     * 
     * @return an array of IPlatformGenModel 
     */
    public static IPlatformGenModel[] getTargetPlatformGenModels(IProject project) {
        return getTargetPlatformManager().getPlatformExtensionPoints(project, IPlatformGenModel.class);
    }

    /**
     * Returns a snapshot of known workspace IPlatformGenModel
     * 
     * @return an array of IPlatformGenModel
     */
    public static IPlatformGenModel[] getWorkspaceTargetPlatformGenModels() {
        return getTargetPlatformManager().getWorkspacePlatformExtensionPoints(IPlatformGenModel.class);
    }

    /**
     * Returns a snapshot of known target IPlatformGenModel
     * 
     * @return an array of IPlatformGenModel
     */
    public static IPlatformGenModel[] getNonWorkspaceTargetPlatformGenModels() {
        return getTargetPlatformManager().getTargetPlatformExtensionPoints(IPlatformGenModel.class);
    }

    /**
     * Returns a snapshot of known runtime IPlatformGenModel
     * 
     * @return an array of IPlatformGenModel
     */
    public static IPlatformGenModel[] getRuntimePlatformGenModels() {
        return getRuntimePlatformManager().getPlatformExtensionPoints(IPlatformGenModel.class);
    }

    /**
     * Returns a snapshot of known target platform IPlatformGenModel
     * 
     * @return an array of IPlatformGenModel
     */
    public static IPlatformGenModel[] getTargetPlatformGenModels() {
        return getTargetPlatformManager().getPlatformExtensionPoints(IPlatformGenModel.class);
    }

    /**
     * Get an IPlatformGenModel for a given uri
     * 
     * @return an IPlatformGenModel 
     */
    public static IPlatformGenModel getTargetPlatformGenModel(URI uri) {
        return PlatformGenModel.getTargetPlatformGenModels().get(uri);
    }

    /**
     * Get the platform IPlatformGenModel location map
     * 
     * @return a Map<URI, URI> 
     */
    public static Map<URI, URI> getTargetPlatformGenModelLocationMap() {
        return PlatformGenModel.getTargetPlatformGenModelLocationMap();
    }

    /**
     * Get an IPlatformGenModel for a given NsURI
     * 
     * @return an IPlatformGenModel 
     */
    public static IPlatformGenModel getRuntimePlatformGenModel(URI uri) {
        return PlatformGenModel.getRuntimePlatformGenModels().get(uri);
    }

    /**
     * Get the platform IPlatformGenModel location map
     * 
     * @return a Map<URI, URI> 
     */
    public static Map<URI, URI> getRuntimePlatformGenModelLocationMap() {
        return PlatformGenModel.getRuntimePlatformGenModelLocationMap();
    }

    /**
     * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        __plugin = this;
        // Force EGF Core Platform Plugin initialization
        Bundle platform = Platform.getBundle("org.eclipse.egf.core.platform"); //$NON-NLS-1$
        if (platform != null) {
            try {
                platform.start(Bundle.START_TRANSIENT);
            } catch (BundleException e) {
                logError(e);
            }
        }
        // Bundle Listener
        if (isDebugging()) {
            __bundleListener = new EGFBundleListener();
            context.addBundleListener(__bundleListener);
        }
    }

    /**
     * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        if (__proxyTargetPlatformFactory != null) {
            __proxyTargetPlatformFactory = null;
        }
        if (__fcoreProcessorRegistry != null) {
            __fcoreProcessorRegistry.dispose();
            __fcoreProcessorRegistry = null;
        }
        if (__bundleListener != null) {
            context.removeBundleListener(__bundleListener);
            __bundleListener = null;
        }
        super.stop(context);
        __plugin = null;
    }

}
