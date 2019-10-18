package br.com.rbsj.event;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ResourceListener implements ApplicationListener<ResourceEvent> {

	@Override
	public void onApplicationEvent(ResourceEvent event) {
		HttpServletResponse response = event.getResp();
		Long id = event.getId();

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
	}

}
