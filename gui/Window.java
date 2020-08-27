package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import gui.layouts.BaseLayout;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private int width, height;
	private String title;
	private boolean resizable;
	private BaseLayout layout;

	public Window(int height, int width,String title, boolean resizable) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.resizable = resizable;
	}
	
	public void init(BaseLayout layout) {
		this.setSize(this.width, this.height);
		this.setTitle(title);
		this.setResizable(resizable);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.layout = layout;
		this.layout.init(this);
		this.revalidate();
	}
	
	public void closeDisplay() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
		
	public void addEventListener(PropertyChangeListener eventListener) {
		this.addEventListener(eventListener);
	}
	
	public void addComponent(Component c) {
		this.add(c);
		this.revalidate();
	}
	
	public void removeComponent(Component c) {
		this.remove(c);
		this.revalidate();
	}
	
	public void removeComponent(int index) {
		this.remove(index);
		this.revalidate();
	}
	
	private void setDimensions(int width, int height) {
		this.height = height;
		this.width = width;
	}
	
	private void setDimensions(Dimension dimension) {
		this.height = (int)dimension.getHeight();
		this.width = (int)dimension.getWidth();
	}
}
