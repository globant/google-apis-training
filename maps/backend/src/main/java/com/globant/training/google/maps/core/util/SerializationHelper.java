package com.globant.training.google.maps.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Serialization helper.
 * 
 * @author gaston.aguilera
 */
public class SerializationHelper {

  private static Logger logger = Logger.getLogger(SerializationHelper.class.getName());


  /**
   * Returns a global thread-safe instance.
   */
  public static SerializationHelper getDefaultInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Holder for the result of {@link #getDefaultInstance()}.
   */
  static class InstanceHolder {
    static final SerializationHelper INSTANCE = new SerializationHelper();
  }

  /**
   * Private constructor.
   */
  private SerializationHelper() {}

  /**
   * Serializes an {@link Serializable} object to a byte[] array.
   * 
   * @param serializable the object to be serialized.
   * @return the byte[].
   * @throws IOException if cannot be serialized.
   */
  public byte[] serialize(Serializable serializable) {
    
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutput out = null;
    byte[] objectBytes = null;
    
    try {
      out = new ObjectOutputStream(bos);
      out.writeObject(serializable);
      
      objectBytes = bos.toByteArray();
      return objectBytes;
      
    } catch (IOException ex) {
      
      logger.log(Level.SEVERE, "Cannot serialize", ex);
      throw new RuntimeException("Cannot serialize", ex);
      
    } finally {
      
      try {
        if (out != null) {
          out.close();
        }
      } catch (IOException ex) {
        logger.log(Level.FINE, "Cannot close ObjectOutput on serialization", ex);
      }
      try {
        bos.close();
      } catch (IOException ex) {
        logger.log(Level.FINE, "Cannot close ByteArrayOutputStream on serialization", ex);
      }
      
    }
  }

  /**
   * Deserialize to Serializable a byte[] array.
   * 
   * @param bytes bytes to be Deserialized.
   * @return {@link Serializable}
   * @throws IOException on deserialization error.
   * @throws ClassNotFoundException on class not found error.
   */
  public Serializable deserialize(byte[] bytes) {
    
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    ObjectInput in = null;
    
    try {
      
      in = new ObjectInputStream(bis);
      Object object = in.readObject();

      Serializable eventDto = (Serializable) object;
      return eventDto;
      
    } catch (IOException | ClassNotFoundException ex) {
      
      logger.log(Level.SEVERE, "Cannot deserialize", ex);
      throw new RuntimeException("Cannot deserialize", ex);
      
    } finally {
      
      try {
        bis.close();
      } catch (IOException ex) {
        logger.log(Level.FINE, "Cannot close ByteArrayInputStream on serialization", ex);
      }
      try {
        if (in != null) {
          in.close();
        }
      } catch (IOException ex) {
        logger.log(Level.FINE, "Cannot close ObjectInput on serialization", ex);
      }
    }
    
  }
}
