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
    comments = "Source: device_register.proto")
public final class DeviceRegisterServiceGrpc {

  private DeviceRegisterServiceGrpc() {}

  public static final String SERVICE_NAME = "axis.transactions.DeviceRegisterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest,
      com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse> getRegisterDeviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterDevice",
      requestType = com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest.class,
      responseType = com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest,
      com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse> getRegisterDeviceMethod() {
    io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest, com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse> getRegisterDeviceMethod;
    if ((getRegisterDeviceMethod = DeviceRegisterServiceGrpc.getRegisterDeviceMethod) == null) {
      synchronized (DeviceRegisterServiceGrpc.class) {
        if ((getRegisterDeviceMethod = DeviceRegisterServiceGrpc.getRegisterDeviceMethod) == null) {
          DeviceRegisterServiceGrpc.getRegisterDeviceMethod = getRegisterDeviceMethod =
              io.grpc.MethodDescriptor.<com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest, com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterDevice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getRegisterDeviceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeviceRegisterServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceRegisterServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceRegisterServiceStub>() {
        @java.lang.Override
        public DeviceRegisterServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceRegisterServiceStub(channel, callOptions);
        }
      };
    return DeviceRegisterServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeviceRegisterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceRegisterServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceRegisterServiceBlockingStub>() {
        @java.lang.Override
        public DeviceRegisterServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceRegisterServiceBlockingStub(channel, callOptions);
        }
      };
    return DeviceRegisterServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeviceRegisterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceRegisterServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceRegisterServiceFutureStub>() {
        @java.lang.Override
        public DeviceRegisterServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceRegisterServiceFutureStub(channel, callOptions);
        }
      };
    return DeviceRegisterServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DeviceRegisterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerDevice(com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterDeviceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterDeviceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest,
                com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse>(
                  this, METHODID_REGISTER_DEVICE)))
          .build();
    }
  }

  /**
   */
  public static final class DeviceRegisterServiceStub extends io.grpc.stub.AbstractAsyncStub<DeviceRegisterServiceStub> {
    private DeviceRegisterServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceRegisterServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceRegisterServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerDevice(com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterDeviceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DeviceRegisterServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DeviceRegisterServiceBlockingStub> {
    private DeviceRegisterServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceRegisterServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceRegisterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse registerDevice(com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterDeviceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DeviceRegisterServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DeviceRegisterServiceFutureStub> {
    private DeviceRegisterServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceRegisterServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceRegisterServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse> registerDevice(
        com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterDeviceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_DEVICE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DeviceRegisterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeviceRegisterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_DEVICE:
          serviceImpl.registerDevice((com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterRequest) request,
              (io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DeviceRegister.DeviceRegisterResponse>) responseObserver);
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
      synchronized (DeviceRegisterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getRegisterDeviceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
