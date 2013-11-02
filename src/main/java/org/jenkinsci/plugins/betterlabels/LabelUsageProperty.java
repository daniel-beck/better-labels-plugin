package org.jenkinsci.plugins.betterlabels;

import hudson.Extension;
import hudson.model.Action;
import hudson.model.labels.LabelAtomProperty;
import hudson.model.labels.LabelAtomPropertyDescriptor;
import hudson.model.labels.LabelAtom;

import java.util.ArrayList;
import java.util.Collection;

import org.kohsuke.stapler.DataBoundConstructor;

public class LabelUsageProperty extends LabelAtomProperty {
	
	@DataBoundConstructor
	public LabelUsageProperty() {
		// required
	}
	
	@Override
	public Collection<? extends Action> getActions(LabelAtom atom) {
		Collection<Action> c = new ArrayList<Action>();
		c.addAll(super.getActions(atom));
		c.add(new LabelUsageAction(atom));
		return c;
	}
	
	@Extension
	public static class DescriptorImpl extends LabelAtomPropertyDescriptor {

		@Override
		public String getDisplayName() {
			return "Provide Label Usage Information";
		}
	}
}
