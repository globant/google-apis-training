package com.globant.training.google.maps.core.event.worker;

import com.globant.training.google.maps.core.util.SerializationHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A base worker to be used with push queues.
 *
 * @param <D> dto type that it's published in queues.
 * 
 * @author gaston.aguilera
 */
public abstract class BaseWorker<D> extends HttpServlet {

  private static final long serialVersionUID = 1L;

  private static final Logger logger = Logger.getLogger(BaseWorker.class.getName());
  private static SerializationHelper serializer = SerializationHelper.getDefaultInstance();

  /**
   * Process is called once dto is avaliable.
   * Whis is the real procesing implementation.
   * 
   * @param dto the dto to be process.
   */
  public abstract void process(D dto);

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    logger.info("Worker is processing .");

    D dto = getDto(request);
    if (dto != null) {
      process(dto);
    }
    logger.info("Notification Worker done.");
  }

  @SuppressWarnings("unchecked")
  protected D getDto(HttpServletRequest req) throws IOException {
    byte[] payload = getPayload(req);
    D dto = null;
    if (payload != null) {
      dto = (D) serializer.deserialize(payload);
    }
    return dto;
  }

  /**
   * Gets the byte[] from request.
   * 
   * @param req the HttpServletRequest request.
   * @return byte[]
   * @throws IOException on any IO exception.
   */
  protected byte[] getPayload(HttpServletRequest req) throws IOException {

    InputStream inputStream = req.getInputStream();
    ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
    byte[] payload = null;
    try {
      int length;
      byte[] buffer = new byte[1024];

      while ((length = inputStream.read(buffer)) >= 0) {
        byteArrayStream.write(buffer, 0, length);
      }

      if (byteArrayStream.size() > 0) {
        payload = byteArrayStream.toByteArray();
      }
    } finally {
      try {
        byteArrayStream.close();
      } catch (IOException ex) {
        logger.log(Level.FINE, "Cannot close ByteArrayInputStream on serialization", ex);
      }
      try {
        if (inputStream != null) {
          inputStream.close();
        }
      } catch (IOException ex) {
        logger.log(Level.FINE, "Cannot close ObjectInput on serialization", ex);
      }
    }
    return payload;
  }
}
