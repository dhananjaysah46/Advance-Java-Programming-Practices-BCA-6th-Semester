package com.advancejava.mvc;

public interface DatabaseCallback {
	
	void onDataEntrySuccess();
	
	void onDataEntryFailure(String error);

}
