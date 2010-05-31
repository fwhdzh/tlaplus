package org.lamport.tla.toolbox.tool.prover.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ProverUIActivator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.lamport.tla.toolbox.tool.prover.ui";

    // The shared instance
    private static ProverUIActivator plugin;

    /**
     * The constructor
     */
    public ProverUIActivator()
    {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception
    {
        super.start(context);
        plugin = this;

        /*
         * The following was commented out by DR to make it easier to
         * understand how the obligations view is updated. Initially this
         * code got new obligation markers indirectly through a resource
         * change listener and passed them to the obligation view. Now
         * the obligations view is informed of new markers and of marker
         * deletions by the classes that call the marker creation and deletion,
         * namely, TagBasedTLAPMOutputIncrementalParser and ProverJob.
         * Add a resource change listener that reacts to new obligation
         * markers by updating the obligations view.
         */
        // IWorkspace workspace = ResourcesPlugin.getWorkspace();
        //
        // workspace.addResourceChangeListener(new IResourceChangeListener() {
        //
        // public void resourceChanged(IResourceChangeEvent event)
        // {
        // final IMarkerDelta[] deltas = event.findMarkerDeltas(ProverHelper.OBLIGATION_MARKER, false);
        // if (deltas.length == 0)
        // {
        // return;
        // }
        //
        // /*
        // * Update the obligation view with any obligation markers
        // * that have been added or modified.
        // *
        // * If any obligation markers have been deleted, this indicates that the prover
        // * has been relaunched. When the prover is relaunched, old obligation
        // * markers are deleted. We can clear the information of these old obligation
        // * markers from the obligation view by calling
        // * ObligationView.refreshObligationView().
        // */
        // boolean markersDeleted = false;
        // for (int i = 0; i < deltas.length; i++)
        // {
        // if (deltas[i].getType().equals(ProverHelper.OBLIGATION_MARKER))
        // {
        // if (deltas[i].getKind() == IResourceDelta.ADDED
        // || deltas[i].getKind() == IResourceDelta.CHANGED)
        // {
        // final IMarker marker = deltas[i].getMarker();
        // UIHelper.runUIAsync(new Runnable() {
        //
        // public void run()
        // {
        // ObligationsView.updateObligationView(marker);
        // }
        // });
        //
        // } else
        // {
        // markersDeleted = true;
        // }
        // }
        // }
        //
        // if (markersDeleted)
        // {
        // UIHelper.runUIAsync(new Runnable() {
        //
        // public void run()
        // {
        // ObligationsView.refreshObligationView();
        // }
        // });
        // }
        //
        // }
        // }, IResourceChangeEvent.POST_CHANGE);
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception
    {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static ProverUIActivator getDefault()
    {
        return plugin;
    }

    public static void logError(String string, Throwable e)
    {
        getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, string, e));
    }

    public static void logDebug(String message)
    {
        System.out.println(message);

    }

}
