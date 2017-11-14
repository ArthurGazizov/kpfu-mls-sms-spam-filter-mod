package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.param;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
public final class Builder {
  private String sms;

  private Builder() {
  }

  public static Builder aMessage() {
    return new Builder();
  }

  public Builder sms(String sms) {
    this.sms = sms;
    return this;
  }

  public Message build() {
    Message message = new Message();
    message.setSms(sms);
    return message;
  }
}
