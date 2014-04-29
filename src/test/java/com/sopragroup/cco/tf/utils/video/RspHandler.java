package com.sopragroup.cco.tf.utils.video;
public class RspHandler {
	private byte[] rsp = null;
	
	public synchronized boolean handleResponse(byte[] rsp) {
		this.rsp = rsp;
		this.notify();
		return true;
	}
	
	public synchronized void waitForResponse() {
		while(this.rsp == null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println(new String(this.rsp));
	}
	
	public synchronized String waitForResponseString() {
		while(this.rsp == null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		
		return new String(this.rsp);
	}
}
