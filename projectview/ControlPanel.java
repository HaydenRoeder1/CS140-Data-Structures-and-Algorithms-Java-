package projectview;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ControlPanel implements Observer{

	private JMenuItem stepButton = new JMenuItem("Step");
	private JMenuItem clearButton = new JMenuItem("Clear");
	private JMenuItem runButton = new JMenuItem("Run/Pause");
	private JMenuItem reload = new JMenuItem("Reload");
	private ViewMediator view;
	
	public ControlPanel(ViewMediator gui) { 
	     view = gui; 
	     gui.addObserver(this); 
	}
	
	public JComponent createControlDisplay() {
		JPanel panel = new JPanel();
	
		stepButton.addActionListener(e -> view.step());
		panel.add(stepButton);
		
		clearButton.addActionListener(e -> view.clearJob());
		panel.add(clearButton);
		
		runButton.addActionListener(e -> view.toggleAutoStep());
		panel.add(runButton);
		
		reload.addActionListener(e -> view.reload());
		panel.add(reload);
		
		JSlider slider = new JSlider(1,3000);
		slider.addChangeListener(e -> view.setPeriod(slider.getValue()));
		panel.add(slider);
		
		return panel;
	}
	
	public void update(Observable arg0, Object arg1) {
		stepButton.setEnabled(view.getCurrentState().getStepActive());
		clearButton.setEnabled(view.getCurrentState().getClearActive());
		runButton.setEnabled(view.getCurrentState().getRunPauseActive());
		reload.setEnabled(view.getCurrentState().getReloadActive());
	}
}
