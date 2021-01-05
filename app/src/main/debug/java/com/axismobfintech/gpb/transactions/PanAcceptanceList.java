// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Protos/pan_acceptance_list.proto

package com.axismobfintech.gpb.transactions;

public final class PanAcceptanceList {
  private PanAcceptanceList() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface PrimaryAccountNumberWhiteListOrBuilder extends
      // @@protoc_insertion_point(interface_extends:axis.transactions.PrimaryAccountNumberWhiteList)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <pre>
     *Identificação da tabela PANs aceitos (fixo 06)
     * </pre>
     *
     * <code>int32 message_id = 1;</code>
     * @return The messageId.
     */
    int getMessageId();

    /**
     * <pre>
     *Índice do registro na tabela (0001 - 9999)
     * </pre>
     *
     * <code>int32 index = 2;</code>
     * @return The index.
     */
    int getIndex();

    /**
     * <pre>
     *Motivo da inclus�o do cartão na lista
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
     *Parte inicial do SHA-256 do PAN do cartão
     * </pre>
     *
     * <code>bytes initial_pan_crypt = 5;</code>
     * @return The initialPanCrypt.
     */
    com.google.protobuf.ByteString getInitialPanCrypt();

    /**
     * <pre>
     *PAN Sequence Number (objeto de tag 5F34h)
     * </pre>
     *
     * <code>string pan_sequence_number = 6;</code>
     * @return The panSequenceNumber.
     */
    java.lang.String getPanSequenceNumber();
    /**
     * <pre>
     *PAN Sequence Number (objeto de tag 5F34h)
     * </pre>
     *
     * <code>string pan_sequence_number = 6;</code>
     * @return The bytes for panSequenceNumber.
     */
    com.google.protobuf.ByteString
        getPanSequenceNumberBytes();
  }
  /**
   * Protobuf type {@code axis.transactions.PrimaryAccountNumberWhiteList}
   */
  public  static final class PrimaryAccountNumberWhiteList extends
      com.google.protobuf.GeneratedMessageLite<
          PrimaryAccountNumberWhiteList, PrimaryAccountNumberWhiteList.Builder> implements
      // @@protoc_insertion_point(message_implements:axis.transactions.PrimaryAccountNumberWhiteList)
      PrimaryAccountNumberWhiteListOrBuilder {
    private PrimaryAccountNumberWhiteList() {
      initialPanCrypt_ = com.google.protobuf.ByteString.EMPTY;
      panSequenceNumber_ = "";
    }
    public static final int MESSAGE_ID_FIELD_NUMBER = 1;
    private int messageId_;
    /**
     * <pre>
     *Identificação da tabela PANs aceitos (fixo 06)
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
     *Identificação da tabela PANs aceitos (fixo 06)
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
     *Identificação da tabela PANs aceitos (fixo 06)
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
     *Índice do registro na tabela (0001 - 9999)
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
     *Índice do registro na tabela (0001 - 9999)
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
     *Índice do registro na tabela (0001 - 9999)
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
     *Motivo da inclus�o do cartão na lista
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
     *Motivo da inclus�o do cartão na lista
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
     *Motivo da inclus�o do cartão na lista
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

    public static final int INITIAL_PAN_CRYPT_FIELD_NUMBER = 5;
    private com.google.protobuf.ByteString initialPanCrypt_;
    /**
     * <pre>
     *Parte inicial do SHA-256 do PAN do cartão
     * </pre>
     *
     * <code>bytes initial_pan_crypt = 5;</code>
     * @return The initialPanCrypt.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getInitialPanCrypt() {
      return initialPanCrypt_;
    }
    /**
     * <pre>
     *Parte inicial do SHA-256 do PAN do cartão
     * </pre>
     *
     * <code>bytes initial_pan_crypt = 5;</code>
     * @param value The initialPanCrypt to set.
     */
    private void setInitialPanCrypt(com.google.protobuf.ByteString value) {
      value.getClass();
  
      initialPanCrypt_ = value;
    }
    /**
     * <pre>
     *Parte inicial do SHA-256 do PAN do cartão
     * </pre>
     *
     * <code>bytes initial_pan_crypt = 5;</code>
     */
    private void clearInitialPanCrypt() {
      
      initialPanCrypt_ = getDefaultInstance().getInitialPanCrypt();
    }

    public static final int PAN_SEQUENCE_NUMBER_FIELD_NUMBER = 6;
    private java.lang.String panSequenceNumber_;
    /**
     * <pre>
     *PAN Sequence Number (objeto de tag 5F34h)
     * </pre>
     *
     * <code>string pan_sequence_number = 6;</code>
     * @return The panSequenceNumber.
     */
    @java.lang.Override
    public java.lang.String getPanSequenceNumber() {
      return panSequenceNumber_;
    }
    /**
     * <pre>
     *PAN Sequence Number (objeto de tag 5F34h)
     * </pre>
     *
     * <code>string pan_sequence_number = 6;</code>
     * @return The bytes for panSequenceNumber.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getPanSequenceNumberBytes() {
      return com.google.protobuf.ByteString.copyFromUtf8(panSequenceNumber_);
    }
    /**
     * <pre>
     *PAN Sequence Number (objeto de tag 5F34h)
     * </pre>
     *
     * <code>string pan_sequence_number = 6;</code>
     * @param value The panSequenceNumber to set.
     */
    private void setPanSequenceNumber(
        java.lang.String value) {
      value.getClass();
  
      panSequenceNumber_ = value;
    }
    /**
     * <pre>
     *PAN Sequence Number (objeto de tag 5F34h)
     * </pre>
     *
     * <code>string pan_sequence_number = 6;</code>
     */
    private void clearPanSequenceNumber() {
      
      panSequenceNumber_ = getDefaultInstance().getPanSequenceNumber();
    }
    /**
     * <pre>
     *PAN Sequence Number (objeto de tag 5F34h)
     * </pre>
     *
     * <code>string pan_sequence_number = 6;</code>
     * @param value The bytes for panSequenceNumber to set.
     */
    private void setPanSequenceNumberBytes(
        com.google.protobuf.ByteString value) {
      checkByteStringIsUtf8(value);
      panSequenceNumber_ = value.toStringUtf8();
      
    }

    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return (Builder) DEFAULT_INSTANCE.createBuilder();
    }
    public static Builder newBuilder(com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList prototype) {
      return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    /**
     * Protobuf type {@code axis.transactions.PrimaryAccountNumberWhiteList}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList, Builder> implements
        // @@protoc_insertion_point(builder_implements:axis.transactions.PrimaryAccountNumberWhiteList)
        com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteListOrBuilder {
      // Construct using com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <pre>
       *Identificação da tabela PANs aceitos (fixo 06)
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
       *Identificação da tabela PANs aceitos (fixo 06)
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
       *Identificação da tabela PANs aceitos (fixo 06)
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
       *Índice do registro na tabela (0001 - 9999)
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
       *Índice do registro na tabela (0001 - 9999)
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
       *Índice do registro na tabela (0001 - 9999)
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
       *Motivo da inclus�o do cartão na lista
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
       *Motivo da inclus�o do cartão na lista
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
       *Motivo da inclus�o do cartão na lista
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
       *Parte inicial do SHA-256 do PAN do cartão
       * </pre>
       *
       * <code>bytes initial_pan_crypt = 5;</code>
       * @return The initialPanCrypt.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getInitialPanCrypt() {
        return instance.getInitialPanCrypt();
      }
      /**
       * <pre>
       *Parte inicial do SHA-256 do PAN do cartão
       * </pre>
       *
       * <code>bytes initial_pan_crypt = 5;</code>
       * @param value The initialPanCrypt to set.
       * @return This builder for chaining.
       */
      public Builder setInitialPanCrypt(com.google.protobuf.ByteString value) {
        copyOnWrite();
        instance.setInitialPanCrypt(value);
        return this;
      }
      /**
       * <pre>
       *Parte inicial do SHA-256 do PAN do cartão
       * </pre>
       *
       * <code>bytes initial_pan_crypt = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearInitialPanCrypt() {
        copyOnWrite();
        instance.clearInitialPanCrypt();
        return this;
      }

      /**
       * <pre>
       *PAN Sequence Number (objeto de tag 5F34h)
       * </pre>
       *
       * <code>string pan_sequence_number = 6;</code>
       * @return The panSequenceNumber.
       */
      @java.lang.Override
      public java.lang.String getPanSequenceNumber() {
        return instance.getPanSequenceNumber();
      }
      /**
       * <pre>
       *PAN Sequence Number (objeto de tag 5F34h)
       * </pre>
       *
       * <code>string pan_sequence_number = 6;</code>
       * @return The bytes for panSequenceNumber.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString
          getPanSequenceNumberBytes() {
        return instance.getPanSequenceNumberBytes();
      }
      /**
       * <pre>
       *PAN Sequence Number (objeto de tag 5F34h)
       * </pre>
       *
       * <code>string pan_sequence_number = 6;</code>
       * @param value The panSequenceNumber to set.
       * @return This builder for chaining.
       */
      public Builder setPanSequenceNumber(
          java.lang.String value) {
        copyOnWrite();
        instance.setPanSequenceNumber(value);
        return this;
      }
      /**
       * <pre>
       *PAN Sequence Number (objeto de tag 5F34h)
       * </pre>
       *
       * <code>string pan_sequence_number = 6;</code>
       * @return This builder for chaining.
       */
      public Builder clearPanSequenceNumber() {
        copyOnWrite();
        instance.clearPanSequenceNumber();
        return this;
      }
      /**
       * <pre>
       *PAN Sequence Number (objeto de tag 5F34h)
       * </pre>
       *
       * <code>string pan_sequence_number = 6;</code>
       * @param value The bytes for panSequenceNumber to set.
       * @return This builder for chaining.
       */
      public Builder setPanSequenceNumberBytes(
          com.google.protobuf.ByteString value) {
        copyOnWrite();
        instance.setPanSequenceNumberBytes(value);
        return this;
      }

      // @@protoc_insertion_point(builder_scope:axis.transactions.PrimaryAccountNumberWhiteList)
    }
    @java.lang.Override
    @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
    protected final java.lang.Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        java.lang.Object arg0, java.lang.Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList();
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
              "initialPanCrypt_",
              "panSequenceNumber_",
            };
            java.lang.String info =
                "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002\u0004" +
                "\u0003\u0004\u0004\t\u0005\n\u0006\u0208";
            return newMessageInfo(DEFAULT_INSTANCE, info, objects);
        }
        // fall through
        case GET_DEFAULT_INSTANCE: {
          return DEFAULT_INSTANCE;
        }
        case GET_PARSER: {
          com.google.protobuf.Parser<com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList> parser = PARSER;
          if (parser == null) {
            synchronized (com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList.class) {
              parser = PARSER;
              if (parser == null) {
                parser =
                    new DefaultInstanceBasedParser<com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList>(
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


    // @@protoc_insertion_point(class_scope:axis.transactions.PrimaryAccountNumberWhiteList)
    private static final com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList DEFAULT_INSTANCE;
    static {
      PrimaryAccountNumberWhiteList defaultInstance = new PrimaryAccountNumberWhiteList();
      // New instances are implicitly immutable so no need to make
      // immutable.
      DEFAULT_INSTANCE = defaultInstance;
      com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
        PrimaryAccountNumberWhiteList.class, defaultInstance);
    }

    public static com.axismobfintech.gpb.transactions.PanAcceptanceList.PrimaryAccountNumberWhiteList getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<PrimaryAccountNumberWhiteList> PARSER;

    public static com.google.protobuf.Parser<PrimaryAccountNumberWhiteList> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
