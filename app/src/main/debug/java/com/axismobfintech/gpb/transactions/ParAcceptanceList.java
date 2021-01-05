// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Protos/par_acceptance_list.proto

package com.axismobfintech.gpb.transactions;

public final class ParAcceptanceList {
  private ParAcceptanceList() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface PrimaryAccountReferenceWhiteListOrBuilder extends
      // @@protoc_insertion_point(interface_extends:axis.transactions.PrimaryAccountReferenceWhiteList)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <pre>
     *Identificação da tabela PAR aceitos (fixo 07)
     * </pre>
     *
     * <code>int32 message_id = 1;</code>
     * @return The messageId.
     */
    int getMessageId();

    /**
     * <pre>
     *índice do registro na tabela (0001 - 9999)
     * </pre>
     *
     * <code>int32 index = 2;</code>
     * @return The index.
     */
    int getIndex();

    /**
     * <pre>
     *Motivo da inclusão do cartão na lista:
     * </pre>
     *
     * <code>int32 reason = 3;</code>
     * @return The reason.
     */
    int getReason();

    /**
     * <pre>
     *Data da inclusão
     * </pre>
     *
     * <code>.google.protobuf.Timestamp register_date = 4;</code>
     * @return Whether the registerDate field is set.
     */
    boolean hasRegisterDate();
    /**
     * <pre>
     *Data da inclusão
     * </pre>
     *
     * <code>.google.protobuf.Timestamp register_date = 4;</code>
     * @return The registerDate.
     */
    com.google.protobuf.Timestamp getRegisterDate();

    /**
     * <pre>
     *Payment Account Reference (PAR)
     * </pre>
     *
     * <code>int32 payment_account_reference = 5;</code>
     * @return The paymentAccountReference.
     */
    int getPaymentAccountReference();
  }
  /**
   * Protobuf type {@code axis.transactions.PrimaryAccountReferenceWhiteList}
   */
  public  static final class PrimaryAccountReferenceWhiteList extends
      com.google.protobuf.GeneratedMessageLite<
          PrimaryAccountReferenceWhiteList, PrimaryAccountReferenceWhiteList.Builder> implements
      // @@protoc_insertion_point(message_implements:axis.transactions.PrimaryAccountReferenceWhiteList)
      PrimaryAccountReferenceWhiteListOrBuilder {
    private PrimaryAccountReferenceWhiteList() {
    }
    public static final int MESSAGE_ID_FIELD_NUMBER = 1;
    private int messageId_;
    /**
     * <pre>
     *Identificação da tabela PAR aceitos (fixo 07)
     * </pre>
     *
     * <code>int32 message_id = 1;</code>
     * @return The messageId.
     */
    @java.lang.Override
    public int getMessageId() {
      return messageId_;
    }
    /**
     * <pre>
     *Identificação da tabela PAR aceitos (fixo 07)
     * </pre>
     *
     * <code>int32 message_id = 1;</code>
     * @param value The messageId to set.
     */
    private void setMessageId(int value) {
      
      messageId_ = value;
    }
    /**
     * <pre>
     *Identificação da tabela PAR aceitos (fixo 07)
     * </pre>
     *
     * <code>int32 message_id = 1;</code>
     */
    private void clearMessageId() {
      
      messageId_ = 0;
    }

    public static final int INDEX_FIELD_NUMBER = 2;
    private int index_;
    /**
     * <pre>
     *índice do registro na tabela (0001 - 9999)
     * </pre>
     *
     * <code>int32 index = 2;</code>
     * @return The index.
     */
    @java.lang.Override
    public int getIndex() {
      return index_;
    }
    /**
     * <pre>
     *índice do registro na tabela (0001 - 9999)
     * </pre>
     *
     * <code>int32 index = 2;</code>
     * @param value The index to set.
     */
    private void setIndex(int value) {
      
      index_ = value;
    }
    /**
     * <pre>
     *índice do registro na tabela (0001 - 9999)
     * </pre>
     *
     * <code>int32 index = 2;</code>
     */
    private void clearIndex() {
      
      index_ = 0;
    }

    public static final int REASON_FIELD_NUMBER = 3;
    private int reason_;
    /**
     * <pre>
     *Motivo da inclusão do cartão na lista:
     * </pre>
     *
     * <code>int32 reason = 3;</code>
     * @return The reason.
     */
    @java.lang.Override
    public int getReason() {
      return reason_;
    }
    /**
     * <pre>
     *Motivo da inclusão do cartão na lista:
     * </pre>
     *
     * <code>int32 reason = 3;</code>
     * @param value The reason to set.
     */
    private void setReason(int value) {
      
      reason_ = value;
    }
    /**
     * <pre>
     *Motivo da inclusão do cartão na lista:
     * </pre>
     *
     * <code>int32 reason = 3;</code>
     */
    private void clearReason() {
      
      reason_ = 0;
    }

    public static final int REGISTER_DATE_FIELD_NUMBER = 4;
    private com.google.protobuf.Timestamp registerDate_;
    /**
     * <pre>
     *Data da inclusão
     * </pre>
     *
     * <code>.google.protobuf.Timestamp register_date = 4;</code>
     */
    @java.lang.Override
    public boolean hasRegisterDate() {
      return registerDate_ != null;
    }
    /**
     * <pre>
     *Data da inclusão
     * </pre>
     *
     * <code>.google.protobuf.Timestamp register_date = 4;</code>
     */
    @java.lang.Override
    public com.google.protobuf.Timestamp getRegisterDate() {
      return registerDate_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : registerDate_;
    }
    /**
     * <pre>
     *Data da inclusão
     * </pre>
     *
     * <code>.google.protobuf.Timestamp register_date = 4;</code>
     */
    private void setRegisterDate(com.google.protobuf.Timestamp value) {
      value.getClass();
  registerDate_ = value;
      
      }
    /**
     * <pre>
     *Data da inclusão
     * </pre>
     *
     * <code>.google.protobuf.Timestamp register_date = 4;</code>
     */
    @java.lang.SuppressWarnings({"ReferenceEquality"})
    private void mergeRegisterDate(com.google.protobuf.Timestamp value) {
      value.getClass();
  if (registerDate_ != null &&
          registerDate_ != com.google.protobuf.Timestamp.getDefaultInstance()) {
        registerDate_ =
          com.google.protobuf.Timestamp.newBuilder(registerDate_).mergeFrom(value).buildPartial();
      } else {
        registerDate_ = value;
      }
      
    }
    /**
     * <pre>
     *Data da inclusão
     * </pre>
     *
     * <code>.google.protobuf.Timestamp register_date = 4;</code>
     */
    private void clearRegisterDate() {  registerDate_ = null;
      
    }

    public static final int PAYMENT_ACCOUNT_REFERENCE_FIELD_NUMBER = 5;
    private int paymentAccountReference_;
    /**
     * <pre>
     *Payment Account Reference (PAR)
     * </pre>
     *
     * <code>int32 payment_account_reference = 5;</code>
     * @return The paymentAccountReference.
     */
    @java.lang.Override
    public int getPaymentAccountReference() {
      return paymentAccountReference_;
    }
    /**
     * <pre>
     *Payment Account Reference (PAR)
     * </pre>
     *
     * <code>int32 payment_account_reference = 5;</code>
     * @param value The paymentAccountReference to set.
     */
    private void setPaymentAccountReference(int value) {
      
      paymentAccountReference_ = value;
    }
    /**
     * <pre>
     *Payment Account Reference (PAR)
     * </pre>
     *
     * <code>int32 payment_account_reference = 5;</code>
     */
    private void clearPaymentAccountReference() {
      
      paymentAccountReference_ = 0;
    }

    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return (Builder) DEFAULT_INSTANCE.createBuilder();
    }
    public static Builder newBuilder(com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList prototype) {
      return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    /**
     * Protobuf type {@code axis.transactions.PrimaryAccountReferenceWhiteList}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList, Builder> implements
        // @@protoc_insertion_point(builder_implements:axis.transactions.PrimaryAccountReferenceWhiteList)
        com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteListOrBuilder {
      // Construct using com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <pre>
       *Identificação da tabela PAR aceitos (fixo 07)
       * </pre>
       *
       * <code>int32 message_id = 1;</code>
       * @return The messageId.
       */
      @java.lang.Override
      public int getMessageId() {
        return instance.getMessageId();
      }
      /**
       * <pre>
       *Identificação da tabela PAR aceitos (fixo 07)
       * </pre>
       *
       * <code>int32 message_id = 1;</code>
       * @param value The messageId to set.
       * @return This builder for chaining.
       */
      public Builder setMessageId(int value) {
        copyOnWrite();
        instance.setMessageId(value);
        return this;
      }
      /**
       * <pre>
       *Identificação da tabela PAR aceitos (fixo 07)
       * </pre>
       *
       * <code>int32 message_id = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearMessageId() {
        copyOnWrite();
        instance.clearMessageId();
        return this;
      }

      /**
       * <pre>
       *índice do registro na tabela (0001 - 9999)
       * </pre>
       *
       * <code>int32 index = 2;</code>
       * @return The index.
       */
      @java.lang.Override
      public int getIndex() {
        return instance.getIndex();
      }
      /**
       * <pre>
       *índice do registro na tabela (0001 - 9999)
       * </pre>
       *
       * <code>int32 index = 2;</code>
       * @param value The index to set.
       * @return This builder for chaining.
       */
      public Builder setIndex(int value) {
        copyOnWrite();
        instance.setIndex(value);
        return this;
      }
      /**
       * <pre>
       *índice do registro na tabela (0001 - 9999)
       * </pre>
       *
       * <code>int32 index = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearIndex() {
        copyOnWrite();
        instance.clearIndex();
        return this;
      }

      /**
       * <pre>
       *Motivo da inclusão do cartão na lista:
       * </pre>
       *
       * <code>int32 reason = 3;</code>
       * @return The reason.
       */
      @java.lang.Override
      public int getReason() {
        return instance.getReason();
      }
      /**
       * <pre>
       *Motivo da inclusão do cartão na lista:
       * </pre>
       *
       * <code>int32 reason = 3;</code>
       * @param value The reason to set.
       * @return This builder for chaining.
       */
      public Builder setReason(int value) {
        copyOnWrite();
        instance.setReason(value);
        return this;
      }
      /**
       * <pre>
       *Motivo da inclusão do cartão na lista:
       * </pre>
       *
       * <code>int32 reason = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearReason() {
        copyOnWrite();
        instance.clearReason();
        return this;
      }

      /**
       * <pre>
       *Data da inclusão
       * </pre>
       *
       * <code>.google.protobuf.Timestamp register_date = 4;</code>
       */
      @java.lang.Override
      public boolean hasRegisterDate() {
        return instance.hasRegisterDate();
      }
      /**
       * <pre>
       *Data da inclusão
       * </pre>
       *
       * <code>.google.protobuf.Timestamp register_date = 4;</code>
       */
      @java.lang.Override
      public com.google.protobuf.Timestamp getRegisterDate() {
        return instance.getRegisterDate();
      }
      /**
       * <pre>
       *Data da inclusão
       * </pre>
       *
       * <code>.google.protobuf.Timestamp register_date = 4;</code>
       */
      public Builder setRegisterDate(com.google.protobuf.Timestamp value) {
        copyOnWrite();
        instance.setRegisterDate(value);
        return this;
        }
      /**
       * <pre>
       *Data da inclusão
       * </pre>
       *
       * <code>.google.protobuf.Timestamp register_date = 4;</code>
       */
      public Builder setRegisterDate(
          com.google.protobuf.Timestamp.Builder builderForValue) {
        copyOnWrite();
        instance.setRegisterDate(builderForValue.build());
        return this;
      }
      /**
       * <pre>
       *Data da inclusão
       * </pre>
       *
       * <code>.google.protobuf.Timestamp register_date = 4;</code>
       */
      public Builder mergeRegisterDate(com.google.protobuf.Timestamp value) {
        copyOnWrite();
        instance.mergeRegisterDate(value);
        return this;
      }
      /**
       * <pre>
       *Data da inclusão
       * </pre>
       *
       * <code>.google.protobuf.Timestamp register_date = 4;</code>
       */
      public Builder clearRegisterDate() {  copyOnWrite();
        instance.clearRegisterDate();
        return this;
      }

      /**
       * <pre>
       *Payment Account Reference (PAR)
       * </pre>
       *
       * <code>int32 payment_account_reference = 5;</code>
       * @return The paymentAccountReference.
       */
      @java.lang.Override
      public int getPaymentAccountReference() {
        return instance.getPaymentAccountReference();
      }
      /**
       * <pre>
       *Payment Account Reference (PAR)
       * </pre>
       *
       * <code>int32 payment_account_reference = 5;</code>
       * @param value The paymentAccountReference to set.
       * @return This builder for chaining.
       */
      public Builder setPaymentAccountReference(int value) {
        copyOnWrite();
        instance.setPaymentAccountReference(value);
        return this;
      }
      /**
       * <pre>
       *Payment Account Reference (PAR)
       * </pre>
       *
       * <code>int32 payment_account_reference = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearPaymentAccountReference() {
        copyOnWrite();
        instance.clearPaymentAccountReference();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:axis.transactions.PrimaryAccountReferenceWhiteList)
    }
    @java.lang.Override
    @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
    protected final java.lang.Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        java.lang.Object arg0, java.lang.Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList();
        }
        case NEW_BUILDER: {
          return new Builder();
        }
        case BUILD_MESSAGE_INFO: {
            java.lang.Object[] objects = new java.lang.Object[] {
              "messageId_",
              "index_",
              "reason_",
              "registerDate_",
              "paymentAccountReference_",
            };
            java.lang.String info =
                "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0002\u0004" +
                "\u0003\u0004\u0004\t\u0005\u0004";
            return newMessageInfo(DEFAULT_INSTANCE, info, objects);
        }
        // fall through
        case GET_DEFAULT_INSTANCE: {
          return DEFAULT_INSTANCE;
        }
        case GET_PARSER: {
          com.google.protobuf.Parser<com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList> parser = PARSER;
          if (parser == null) {
            synchronized (com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList.class) {
              parser = PARSER;
              if (parser == null) {
                parser =
                    new DefaultInstanceBasedParser<com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList>(
                        DEFAULT_INSTANCE);
                PARSER = parser;
              }
            }
          }
          return parser;
      }
      case GET_MEMOIZED_IS_INITIALIZED: {
        return (byte) 1;
      }
      case SET_MEMOIZED_IS_INITIALIZED: {
        return null;
      }
      }
      throw new UnsupportedOperationException();
    }


    // @@protoc_insertion_point(class_scope:axis.transactions.PrimaryAccountReferenceWhiteList)
    private static final com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList DEFAULT_INSTANCE;
    static {
      PrimaryAccountReferenceWhiteList defaultInstance = new PrimaryAccountReferenceWhiteList();
      // New instances are implicitly immutable so no need to make
      // immutable.
      DEFAULT_INSTANCE = defaultInstance;
      com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
        PrimaryAccountReferenceWhiteList.class, defaultInstance);
    }

    public static com.axismobfintech.gpb.transactions.ParAcceptanceList.PrimaryAccountReferenceWhiteList getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<PrimaryAccountReferenceWhiteList> PARSER;

    public static com.google.protobuf.Parser<PrimaryAccountReferenceWhiteList> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
