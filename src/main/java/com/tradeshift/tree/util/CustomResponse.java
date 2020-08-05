package com.tradeshift.tree.util;

public class CustomResponse<T> {
	
	private String message;
	
	

	private T response;
	
	public CustomResponse() {};
	
    public CustomResponse(T response){
        this.response = response;
    }
	
	public static CustomResponse Message(String s) {
		
		CustomResponse customResponse = new CustomResponse();
		customResponse.message = s;
		
		return customResponse;
	}

}
