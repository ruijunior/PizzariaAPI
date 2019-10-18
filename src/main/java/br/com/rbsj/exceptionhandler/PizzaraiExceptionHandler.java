package br.com.rbsj.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PizzaraiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String msgCliente = messageSource.getMessage("mensagem.invalida", null,  LocaleContextHolder.getLocale());
		String msgDesenvolvedor = ex.getCause().toString();
		
		List<Error> erros = Arrays.asList(new Error(msgCliente, msgDesenvolvedor));
		
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Error> erros = errors(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request); 
	}
	
	private List<Error> errors(BindingResult bindingResult){
		List<Error> erros = new ArrayList<>();
		
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		
		for (FieldError fieldError : fieldErrors) {
			String msgClient = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String msgDeveloper = FieldError.class.toString();
			erros.add(new Error(msgClient, msgDeveloper));
		}
		
		return erros;
	}
	
	public static class Error{
		private String mensagemCliente;
		private String mensagemDesenvolvedor;
		
		public Error(String mensagemCliente, String mensagemDesenvolvedor) {
			super();
			this.mensagemCliente = mensagemCliente;
			this.mensagemDesenvolvedor = mensagemDesenvolvedor;
		}

		public String getMensagemCliente() {
			return mensagemCliente;
		}

		public void setMensagemCliente(String mensagemCliente) {
			this.mensagemCliente = mensagemCliente;
		}

		public String getMensagemDesenvolvedor() {
			return mensagemDesenvolvedor;
		}

		public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
			this.mensagemDesenvolvedor = mensagemDesenvolvedor;
		}
		
	}

}
