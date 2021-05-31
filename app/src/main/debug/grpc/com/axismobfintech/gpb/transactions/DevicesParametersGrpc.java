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
    comments = "Source: device_parameters.proto")
public final class DevicesParametersGrpc {

  private DevicesParametersGrpc() {}

  public static final String SERVICE_NAME = "axis.transactions.DevicesParameters";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceParameters.Parameters,
      com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> getGetDeviceParametersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeviceParameters",
      requestType = com.axismobfintech.gpb.transactions.DeviceParameters.Parameters.class,
      responseType = com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceParameters.Parameters,
      com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> getGetDeviceParametersMethod() {
    io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceParameters.Parameters, com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> getGetDeviceParametersMethod;
    if ((getGetDeviceParametersMethod = DevicesParametersGrpc.getGetDeviceParametersMethod) == null) {
      synchronized (DevicesParametersGrpc.class) {
        if ((getGetDeviceParametersMethod = DevicesParametersGrpc.getGetDeviceParametersMethod) == null) {
          DevicesParametersGrpc.getGetDeviceParametersMethod = getGetDeviceParametersMethod =
              io.grpc.MethodDescriptor.<com.axismobfintech.gpb.transactions.DeviceParameters.Parameters, com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeviceParameters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.DeviceParameters.Parameters.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetDeviceParametersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DevicesParametersStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DevicesParametersStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DevicesParametersStub>() {
        @java.lang.Override
        public DevicesParametersStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DevicesParametersStub(channel, callOptions);
        }
      };
    return DevicesParametersStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DevicesParametersBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DevicesParametersBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DevicesParametersBlockingStub>() {
        @java.lang.Override
        public DevicesParametersBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DevicesParametersBlockingStub(channel, callOptions);
        }
      };
    return DevicesParametersBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DevicesParametersFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DevicesParametersFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DevicesParametersFutureStub>() {
        @java.lang.Override
        public DevicesParametersFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DevicesParametersFutureStub(channel, callOptions);
        }
      };
    return DevicesParametersFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DevicesParametersImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDeviceParameters(com.axismobfintech.gpb.transactions.DeviceParameters.Parameters request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDeviceParametersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDeviceParametersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.axismobfintech.gpb.transactions.DeviceParameters.Parameters,
                com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse>(
                  this, METHODID_GET_DEVICE_PARAMETERS)))
          .build();
    }
  }

  /**
   */
  public static final class DevicesParametersStub extends io.grpc.stub.AbstractAsyncStub<DevicesParametersStub> {
    private DevicesParametersStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DevicesParametersStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DevicesParametersStub(channel, callOptions);
    }

    /**
     */
    public void getDeviceParameters(com.axismobfintech.gpb.transactions.DeviceParameters.Parameters request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDeviceParametersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DevicesParametersBlockingStub extends io.grpc.stub.AbstractBlockingStub<DevicesParametersBlockingStub> {
    private DevicesParametersBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DevicesParametersBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DevicesParametersBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse getDeviceParameters(com.axismobfintech.gpb.transactions.DeviceParameters.Parameters request) {
      return blockingUnaryCall(
          getChannel(), getGetDeviceParametersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DevicesParametersFutureStub extends io.grpc.stub.AbstractFutureStub<DevicesParametersFutureStub> {
    private DevicesParametersFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DevicesParametersFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DevicesParametersFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> getDeviceParameters(
        com.axismobfintech.gpb.transactions.DeviceParameters.Parameters request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDeviceParametersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DEVICE_PARAMETERS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DevicesParametersImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DevicesParametersImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DEVICE_PARAMETERS:
          serviceImpl.getDeviceParameters((com.axismobfintech.gpb.transactions.DeviceParameters.Parameters) request,
              (io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse>) responseObserver);
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
      synchronized (DevicesParametersGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getGetDeviceParametersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
