package com.axismobfintech.gpb.transactions;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.1)",
    comments = "Source: passage_register.proto")
public final class TransactionsGrpc {

  private TransactionsGrpc() {}

  public static final String SERVICE_NAME = "axis.transactions.Transactions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage,
      com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> getMakeTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeTransaction",
      requestType = com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage.class,
      responseType = com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage,
      com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> getMakeTransactionMethod() {
    io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage, com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> getMakeTransactionMethod;
    if ((getMakeTransactionMethod = TransactionsGrpc.getMakeTransactionMethod) == null) {
      synchronized (TransactionsGrpc.class) {
        if ((getMakeTransactionMethod = TransactionsGrpc.getMakeTransactionMethod) == null) {
          TransactionsGrpc.getMakeTransactionMethod = getMakeTransactionMethod =
              io.grpc.MethodDescriptor.<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage, com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MakeTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getMakeTransactionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransactionsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionsStub>() {
        @java.lang.Override
        public TransactionsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionsStub(channel, callOptions);
        }
      };
    return TransactionsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransactionsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionsBlockingStub>() {
        @java.lang.Override
        public TransactionsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionsBlockingStub(channel, callOptions);
        }
      };
    return TransactionsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransactionsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionsFutureStub>() {
        @java.lang.Override
        public TransactionsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionsFutureStub(channel, callOptions);
        }
      };
    return TransactionsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TransactionsImplBase implements io.grpc.BindableService {

    /**
     */
    public void makeTransaction(com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeTransactionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMakeTransactionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage,
                com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse>(
                  this, METHODID_MAKE_TRANSACTION)))
          .build();
    }
  }

  /**
   */
  public static final class TransactionsStub extends io.grpc.stub.AbstractAsyncStub<TransactionsStub> {
    private TransactionsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionsStub(channel, callOptions);
    }

    /**
     */
    public void makeTransaction(com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeTransactionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TransactionsBlockingStub extends io.grpc.stub.AbstractBlockingStub<TransactionsBlockingStub> {
    private TransactionsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionsBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse makeTransaction(com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage request) {
      return blockingUnaryCall(
          getChannel(), getMakeTransactionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TransactionsFutureStub extends io.grpc.stub.AbstractFutureStub<TransactionsFutureStub> {
    private TransactionsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> makeTransaction(
        com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage request) {
      return futureUnaryCall(
          getChannel().newCall(getMakeTransactionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MAKE_TRANSACTION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransactionsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransactionsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MAKE_TRANSACTION:
          serviceImpl.makeTransaction((com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassage) request,
              (io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TransactionsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getMakeTransactionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
