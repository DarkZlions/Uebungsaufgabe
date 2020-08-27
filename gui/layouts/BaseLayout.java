package gui.layouts;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import gui.Window;

public abstract class BaseLayout {
	protected List<Component> componentList;
	protected List<JPanel> panels;
	
	public BaseLayout() {
		componentList = new ArrayList<>();
		panels = new ArrayList<>();
	}
	
	public abstract void init(Window window);
	
	public List<JPanel> getPanel() {
		return this.panels;
	}
	
	public List<Component> getComponets() {
		return this.componentList;
	}
}
