// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UpdateInfoService.proto

package org.example;

public interface UpdateInfoRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.example.UpdateInfoRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 userId = 1;</code>
   * @return The userId.
   */
  int getUserId();

  /**
   * <code>string firstName = 2;</code>
   * @return The firstName.
   */
  java.lang.String getFirstName();
  /**
   * <code>string firstName = 2;</code>
   * @return The bytes for firstName.
   */
  com.google.protobuf.ByteString
      getFirstNameBytes();

  /**
   * <code>string email = 3;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 3;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <pre>
   *  repeated Address address = 5;
   *  message Address {
   *    string street = 1;
   *    string city = 2;
   *    bool isShippingAddress = 3;
   *  }
   * </pre>
   *
   * <code>string phone = 4;</code>
   * @return The phone.
   */
  java.lang.String getPhone();
  /**
   * <pre>
   *  repeated Address address = 5;
   *  message Address {
   *    string street = 1;
   *    string city = 2;
   *    bool isShippingAddress = 3;
   *  }
   * </pre>
   *
   * <code>string phone = 4;</code>
   * @return The bytes for phone.
   */
  com.google.protobuf.ByteString
      getPhoneBytes();
}
