package org.jenkinsci.plugins.betterlabels;

import hudson.Extension;
import hudson.Util;
import hudson.model.Action;
import hudson.model.labels.LabelAtomProperty;
import hudson.model.labels.LabelAtomPropertyDescriptor;
import hudson.model.labels.LabelAtom;

import java.util.ArrayList;
import java.util.Collection;

import org.kohsuke.stapler.DataBoundConstructor;

public class LabelDescriptionProperty extends LabelAtomProperty {

	private String description;
	
	@DataBoundConstructor
	public LabelDescriptionProperty(String description) {
		this.description = description;
	}
	
	@Override
	public Collection<? extends Action> getActions(LabelAtom atom) {
		Collection<Action> c = new ArrayList<Action>();
		c.addAll(super.getActions(atom));
		if (Util.fixEmptyAndTrim(description) != null) {
			c.add(new LabelDescriptionAction(atom, description));
		}
		return c;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	@Extension
	public static class DescriptorImpl extends LabelAtomPropertyDescriptor {

		@Override
		public String getDisplayName() {
			return "Provide Label Description";
		}
	}
}

