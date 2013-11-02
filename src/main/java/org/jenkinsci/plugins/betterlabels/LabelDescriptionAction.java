package org.jenkinsci.plugins.betterlabels;

import hudson.model.Action;
import hudson.model.labels.LabelAtom;

public class LabelDescriptionAction implements Action {

	private LabelAtom atom;
	
	private String description;
	
	public LabelDescriptionAction(LabelAtom atom, String description) {
		this.atom = atom;
		this.description = description;
	}

	public LabelAtom getLabel() {
		return this.atom;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getIconFileName() {
		return "document.png";
	}

	public String getDisplayName() {
		// TODO Auto-generated method stub
		return "Description";
	}

	public String getUrlName() {
		return "labelBescription";
	}

}
