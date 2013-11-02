package org.jenkinsci.plugins.betterlabels;

import hudson.model.Action;
import hudson.model.AbstractProject;
import hudson.model.Label;
import hudson.model.labels.LabelAtom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jenkins.model.Jenkins;

public class LabelUsageAction implements Action {

	private LabelAtom atom;
	
	public LabelUsageAction(LabelAtom atom) {
		this.atom = atom;
	}
	
	public LabelAtom getLabel() {
		return this.atom;
	}
	
	public String getIconFileName() {
		return "clipboard.png";
	}

	public String getDisplayName() {
		return "Usage";
	}

	public String getUrlName() {
		return "labelUsage";
	}
	
	@SuppressWarnings("rawtypes")
	public Map<Label, List<AbstractProject>> getProjectsByAssignedLabel() {
		Map<Label, List<AbstractProject>> projectsByLabels = new HashMap<Label, List<AbstractProject>>();
		
		// iterate over all projects and check their labels
		for (AbstractProject p : Jenkins.getInstance().getAllItems(AbstractProject.class)) {
			Label l = p.getAssignedLabel();
			
			// only consider labels that contain this atom
			if (l != null && l.listAtoms().contains(this.atom)) {
				if (!projectsByLabels.containsKey(l)) {
					projectsByLabels.put(l, new ArrayList<AbstractProject>());
				}
				projectsByLabels.get(l).add(p);
			}
		}
		return projectsByLabels;
	}
}
