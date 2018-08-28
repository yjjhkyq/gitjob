package com.dese100.gitjob.domain;

public enum PasswordFormat {
	 /// <summary>
    /// Clear
    /// </summary>
    Clear(0),
    /// <summary>
    /// Hashed
    /// </summary>
    Hashed(1),
    /// <summary>
    /// Encrypted
    /// </summary>
    Encrypted(2);
    
    private int value = 0;
    
    private PasswordFormat(int value){
        this.value =value;
     } 
    
    public static PasswordFormat valueOf(int value){
        switch(value) {
        case 1:
           return Clear;
        case 2:
           return Hashed;
        case 3:
        	return Encrypted;
       default:
           return null;
        }
     }

     public int value() {
        return this.value;
     }
}
