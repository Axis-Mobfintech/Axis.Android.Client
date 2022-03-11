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
    comments = "Source: debit_recovery.proto")
public final class RecoverDebitServiceGrpc {

  private RecoverDebitServiceGrpc() {}

  public static final String SERVICE_NAME = "axis.transactions.RecoverDebitService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest,
      com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse> getRecoverMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Recover",
      requestType = com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest.class,
      responseType = com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest,
      com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse> getRecoverMethod() {
    io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest, com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse> getRecoverMethod;
    if ((getRecoverMethod = RecoverDebitServiceGrpc.getRecoverMethod) == null) {
      synchronized (RecoverDebitServiceGrpc.class) {
        if ((getRecoverMethod = RecoverDebitServiceGrpc.getRecoverMethod) == null) {
          RecoverDebitServiceGrpc.getRecoverMethod = getRecoverMethod =
              io.grpc.MethodDescriptor.<com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest, com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Recover"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getRecoverMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecoverDebitServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecoverDebitServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecoverDebitServiceStub>() {
        @java.lang.Override
        public RecoverDebitServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecoverDebitServiceStub(channel, callOptions);
        }
      };
    return RecoverDebitServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecoverDebitServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecoverDebitServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecoverDebitServiceBlockingStub>() {
        @java.lang.Override
        public RecoverDebitServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecoverDebitServiceBlockingStub(channel, callOptions);
        }
      };
    return RecoverDebitServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecoverDebitServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecoverDebitServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecoverDebitServiceFutureStub>() {
        @java.lang.Override
        public RecoverDebitServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecoverDebitServiceFutureStub(channel, callOptions);
        }
      };
    return RecoverDebitServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RecoverDebitServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void recover(com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRecoverMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRecoverMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest,
                com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse>(
                  this, METHODID_RECOVER)))
          .build();
    }
  }

  /**
   */
  public static final class RecoverDebitServiceStub extends io.grpc.stub.AbstractAsyncStub<RecoverDebitServiceStub> {
    private RecoverDebitServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecoverDebitServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecoverDebitServiceStub(channel, callOptions);
    }

    /**
     */
    public void recover(com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRecoverMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecoverDebitServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RecoverDebitServiceBlockingStub> {
    private RecoverDebitServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecoverDebitServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecoverDebitServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse recover(com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest request) {
      return blockingUnaryCall(
          getChannel(), getRecoverMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecoverDebitServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RecoverDebitServiceFutureStub> {
    private RecoverDebitServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecoverDebitServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecoverDebitServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse> recover(
        com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRecoverMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECOVER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecoverDebitServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecoverDebitServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECOVER:
          serviceImpl.recover((com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryRequest) request,
              (io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DebitRecovery.DebitRecoveryResponse>) responseObserver);
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
      synchronized (RecoverDebitServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getRecoverMethod())
              .build();
        }
      }
    }
    return result;
  }
}
