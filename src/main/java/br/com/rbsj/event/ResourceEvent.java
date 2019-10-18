package br.com.rbsj.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class ResourceEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private HttpServletResponse resp;
	private Long id;

	public ResourceEvent(Object source, HttpServletResponse resp, Long id) {
		super(source);
		this.resp = resp;
		this.id = id;
	}

	public HttpServletResponse getResp() {
		return resp;
	}

	public Long getId() {
		return id;
	}
}