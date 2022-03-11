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
public final class RegisterPassageServiceGrpc {

  private RegisterPassageServiceGrpc() {}

  public static final String SERVICE_NAME = "axis.transactions.RegisterPassageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest,
      com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> getMakeTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeTransaction",
      requestType = com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest.class,
      responseType = com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest,
      com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> getMakeTransactionMethod() {
    io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest, com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> getMakeTransactionMethod;
    if ((getMakeTransactionMethod = RegisterPassageServiceGrpc.getMakeTransactionMethod) == null) {
      synchronized (RegisterPassageServiceGrpc.class) {
        if ((getMakeTransactionMethod = RegisterPassageServiceGrpc.getMakeTransactionMethod) == null) {
          RegisterPassageServiceGrpc.getMakeTransactionMethod = getMakeTransactionMethod =
              io.grpc.MethodDescriptor.<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest, com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MakeTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest.getDefaultInstance()))
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
  public static RegisterPassageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterPassageServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterPassageServiceStub>() {
        @java.lang.Override
        public RegisterPassageServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterPassageServiceStub(channel, callOptions);
        }
      };
    return RegisterPassageServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegisterPassageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterPassageServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterPassageServiceBlockingStub>() {
        @java.lang.Override
        public RegisterPassageServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterPassageServiceBlockingStub(channel, callOptions);
        }
      };
    return RegisterPassageServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegisterPassageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterPassageServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterPassageServiceFutureStub>() {
        @java.lang.Override
        public RegisterPassageServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterPassageServiceFutureStub(channel, callOptions);
        }
      };
    return RegisterPassageServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RegisterPassageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void makeTransaction(com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeTransactionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMakeTransactionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest,
                com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse>(
                  this, METHODID_MAKE_TRANSACTION)))
          .build();
    }
  }

  /**
   */
  public static final class RegisterPassageServiceStub extends io.grpc.stub.AbstractAsyncStub<RegisterPassageServiceStub> {
    private RegisterPassageServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterPassageServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterPassageServiceStub(channel, callOptions);
    }

    /**
     */
    public void makeTransaction(com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeTransactionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RegisterPassageServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RegisterPassageServiceBlockingStub> {
    private RegisterPassageServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterPassageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterPassageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse makeTransaction(com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest request) {
      return blockingUnaryCall(
          getChannel(), getMakeTransactionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RegisterPassageServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RegisterPassageServiceFutureStub> {
    private RegisterPassageServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterPassageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterPassageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageResponse> makeTransaction(
        com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest request) {
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
    private final RegisterPassageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegisterPassageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MAKE_TRANSACTION:
          serviceImpl.makeTransaction((com.axismobfintech.gpb.transactions.PassageRegister.RegisterPassageRequest) request,
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
      synchronized (RegisterPassageServiceGrpc.class) {
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
