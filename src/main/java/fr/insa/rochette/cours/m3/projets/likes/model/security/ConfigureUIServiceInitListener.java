/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package fr.insa.rochette.cours.m3.projets.likes.model.security;

/**
 *
 * @author sarah
 */

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import fr.insa.rochette.cours.m3.projets.likes.model.view.LoginView;
import org.springframework.stereotype.Component;

@Component 


public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

	@Override
	public void serviceInit(ServiceInitEvent event) { 


		event.getSource().addUIInitListener(uiEvent -> {
			final UI ui = uiEvent.getUI();
			ui.addBeforeEnterListener(this::authenticateNavigation);
		});
	}

	private void authenticateNavigation(BeforeEnterEvent event) { 


		if (!LoginView.class.equals(event.getNavigationTarget())
		    && !SecurityUtils.isUserLoggedIn()) {
			event.rerouteTo(LoginView.class);
		}
	}
}
