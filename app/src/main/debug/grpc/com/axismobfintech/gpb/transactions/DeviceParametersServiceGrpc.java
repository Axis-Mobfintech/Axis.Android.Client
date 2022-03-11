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
public final class DeviceParametersServiceGrpc {

  private DeviceParametersServiceGrpc() {}

  public static final String SERVICE_NAME = "axis.transactions.DeviceParametersService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest,
      com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> getGetDeviceParametersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeviceParameters",
      requestType = com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest.class,
      responseType = com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest,
      com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> getGetDeviceParametersMethod() {
    io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest, com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> getGetDeviceParametersMethod;
    if ((getGetDeviceParametersMethod = DeviceParametersServiceGrpc.getGetDeviceParametersMethod) == null) {
      synchronized (DeviceParametersServiceGrpc.class) {
        if ((getGetDeviceParametersMethod = DeviceParametersServiceGrpc.getGetDeviceParametersMethod) == null) {
          DeviceParametersServiceGrpc.getGetDeviceParametersMethod = getGetDeviceParametersMethod =
              io.grpc.MethodDescriptor.<com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest, com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeviceParameters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest.getDefaultInstance()))
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
  public static DeviceParametersServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceParametersServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceParametersServiceStub>() {
        @java.lang.Override
        public DeviceParametersServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceParametersServiceStub(channel, callOptions);
        }
      };
    return DeviceParametersServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeviceParametersServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceParametersServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceParametersServiceBlockingStub>() {
        @java.lang.Override
        public DeviceParametersServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceParametersServiceBlockingStub(channel, callOptions);
        }
      };
    return DeviceParametersServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeviceParametersServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceParametersServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceParametersServiceFutureStub>() {
        @java.lang.Override
        public DeviceParametersServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceParametersServiceFutureStub(channel, callOptions);
        }
      };
    return DeviceParametersServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DeviceParametersServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDeviceParameters(com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDeviceParametersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDeviceParametersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest,
                com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse>(
                  this, METHODID_GET_DEVICE_PARAMETERS)))
          .build();
    }
  }

  /**
   */
  public static final class DeviceParametersServiceStub extends io.grpc.stub.AbstractAsyncStub<DeviceParametersServiceStub> {
    private DeviceParametersServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceParametersServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceParametersServiceStub(channel, callOptions);
    }

    /**
     */
    public void getDeviceParameters(com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDeviceParametersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DeviceParametersServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DeviceParametersServiceBlockingStub> {
    private DeviceParametersServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceParametersServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceParametersServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse getDeviceParameters(com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDeviceParametersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DeviceParametersServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DeviceParametersServiceFutureStub> {
    private DeviceParametersServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceParametersServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceParametersServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.axismobfintech.gpb.transactions.DeviceParameters.ParametersResponse> getDeviceParameters(
        com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest request) {
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
    private final DeviceParametersServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeviceParametersServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DEVICE_PARAMETERS:
          serviceImpl.getDeviceParameters((com.axismobfintech.gpb.transactions.DeviceParameters.ParametersRequest) request,
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
      synchronized (DeviceParametersServiceGrpc.class) {
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
