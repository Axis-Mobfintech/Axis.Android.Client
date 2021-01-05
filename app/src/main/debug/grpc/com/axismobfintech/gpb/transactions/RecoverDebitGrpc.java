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
public final class RecoverDebitGrpc {

  private RecoverDebitGrpc() {}

  public static final String SERVICE_NAME = "axis.transactions.RecoverDebit";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery,
      com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse> getRecoverMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Recover",
      requestType = com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery.class,
      responseType = com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery,
      com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse> getRecoverMethod() {
    io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery, com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse> getRecoverMethod;
    if ((getRecoverMethod = RecoverDebitGrpc.getRecoverMethod) == null) {
      synchronized (RecoverDebitGrpc.class) {
        if ((getRecoverMethod = RecoverDebitGrpc.getRecoverMethod) == null) {
          RecoverDebitGrpc.getRecoverMethod = getRecoverMethod =
              io.grpc.MethodDescriptor.<com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery, com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Recover"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getRecoverMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecoverDebitStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecoverDebitStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecoverDebitStub>() {
        @java.lang.Override
        public RecoverDebitStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecoverDebitStub(channel, callOptions);
        }
      };
    return RecoverDebitStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecoverDebitBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecoverDebitBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecoverDebitBlockingStub>() {
        @java.lang.Override
        public RecoverDebitBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecoverDebitBlockingStub(channel, callOptions);
        }
      };
    return RecoverDebitBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecoverDebitFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecoverDebitFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecoverDebitFutureStub>() {
        @java.lang.Override
        public RecoverDebitFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecoverDebitFutureStub(channel, callOptions);
        }
      };
    return RecoverDebitFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RecoverDebitImplBase implements io.grpc.BindableService {

    /**
     */
    public void recover(com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRecoverMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRecoverMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery,
                com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse>(
                  this, METHODID_RECOVER)))
          .build();
    }
  }

  /**
   */
  public static final class RecoverDebitStub extends io.grpc.stub.AbstractAsyncStub<RecoverDebitStub> {
    private RecoverDebitStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecoverDebitStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecoverDebitStub(channel, callOptions);
    }

    /**
     */
    public void recover(com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRecoverMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecoverDebitBlockingStub extends io.grpc.stub.AbstractBlockingStub<RecoverDebitBlockingStub> {
    private RecoverDebitBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecoverDebitBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecoverDebitBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse recover(com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery request) {
      return blockingUnaryCall(
          getChannel(), getRecoverMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecoverDebitFutureStub extends io.grpc.stub.AbstractFutureStub<RecoverDebitFutureStub> {
    private RecoverDebitFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecoverDebitFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecoverDebitFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse> recover(
        com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery request) {
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
    private final RecoverDebitImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecoverDebitImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECOVER:
          serviceImpl.recover((com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecovery) request,
              (io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DebitRecoveryOuterClass.DebitRecoveryResponse>) responseObserver);
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
      synchronized (RecoverDebitGrpc.class) {
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
