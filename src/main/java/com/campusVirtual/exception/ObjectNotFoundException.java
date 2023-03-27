package com.campusVirtual.exception;


public class ObjectNotFoundException extends RuntimeException {

  public ObjectNotFoundException(String message) {
    super(message);
  }

  public ObjectNotFoundException(String objectName,Long idObject) {
    super("Object type: {"+objectName+"}, with ID: {"+idObject+"} Not found.");
    }

  public ObjectNotFoundException(String objectName,String idObject) {
    super("Object type: {"+objectName+"}, with ID: {"+idObject+"} Not found.");
        }
}
