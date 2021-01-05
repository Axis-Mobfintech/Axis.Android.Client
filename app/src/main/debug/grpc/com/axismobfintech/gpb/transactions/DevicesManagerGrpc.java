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
public final class DevicesManagerGrpc {

  private DevicesManagerGrpc() {}

  public static final String SERVICE_NAME = "axis.transactions.DevicesManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister,
      com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse> getRegisterDeviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterDevice",
      requestType = com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister.class,
      responseType = com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister,
      com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse> getRegisterDeviceMethod() {
    io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister, com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse> getRegisterDeviceMethod;
    if ((getRegisterDeviceMethod = DevicesManagerGrpc.getRegisterDeviceMethod) == null) {
      synchronized (DevicesManagerGrpc.class) {
        if ((getRegisterDeviceMethod = DevicesManagerGrpc.getRegisterDeviceMethod) == null) {
          DevicesManagerGrpc.getRegisterDeviceMethod = getRegisterDeviceMethod =
              io.grpc.MethodDescriptor.<com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister, com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterDevice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getRegisterDeviceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DevicesManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DevicesManagerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DevicesManagerStub>() {
        @java.lang.Override
        public DevicesManagerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DevicesManagerStub(channel, callOptions);
        }
      };
    return DevicesManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DevicesManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DevicesManagerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DevicesManagerBlockingStub>() {
        @java.lang.Override
        public DevicesManagerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DevicesManagerBlockingStub(channel, callOptions);
        }
      };
    return DevicesManagerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DevicesManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DevicesManagerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DevicesManagerFutureStub>() {
        @java.lang.Override
        public DevicesManagerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DevicesManagerFutureStub(channel, callOptions);
        }
      };
    return DevicesManagerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DevicesManagerImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerDevice(com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterDeviceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterDeviceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister,
                com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse>(
                  this, METHODID_REGISTER_DEVICE)))
          .build();
    }
  }

  /**
   */
  public static final class DevicesManagerStub extends io.grpc.stub.AbstractAsyncStub<DevicesManagerStub> {
    private DevicesManagerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DevicesManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DevicesManagerStub(channel, callOptions);
    }

    /**
     */
    public void registerDevice(com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterDeviceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DevicesManagerBlockingStub extends io.grpc.stub.AbstractBlockingStub<DevicesManagerBlockingStub> {
    private DevicesManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DevicesManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DevicesManagerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse registerDevice(com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister request) {
      return blockingUnaryCall(
          getChannel(), getRegisterDeviceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DevicesManagerFutureStub extends io.grpc.stub.AbstractFutureStub<DevicesManagerFutureStub> {
    private DevicesManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DevicesManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DevicesManagerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse> registerDevice(
        com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister request) {
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
    private final DevicesManagerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DevicesManagerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_DEVICE:
          serviceImpl.registerDevice((com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegister) request,
              (io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass.DeviceRegisterResponse>) responseObserver);
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
      synchronized (DevicesManagerGrpc.class) {
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
