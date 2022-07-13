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
    comments = "Source: Protos/monitor_statistics.proto")
public final class MonitorStatisticsServiceGrpc {

  private MonitorStatisticsServiceGrpc() {}

  public static final String SERVICE_NAME = "axis.transactions.MonitorStatisticsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest,
      com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse> getMonitorStatisticsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorStatistics",
      requestType = com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest.class,
      responseType = com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest,
      com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse> getMonitorStatisticsMethod() {
    io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest, com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse> getMonitorStatisticsMethod;
    if ((getMonitorStatisticsMethod = MonitorStatisticsServiceGrpc.getMonitorStatisticsMethod) == null) {
      synchronized (MonitorStatisticsServiceGrpc.class) {
        if ((getMonitorStatisticsMethod = MonitorStatisticsServiceGrpc.getMonitorStatisticsMethod) == null) {
          MonitorStatisticsServiceGrpc.getMonitorStatisticsMethod = getMonitorStatisticsMethod =
              io.grpc.MethodDescriptor.<com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest, com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorStatistics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getMonitorStatisticsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MonitorStatisticsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitorStatisticsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitorStatisticsServiceStub>() {
        @java.lang.Override
        public MonitorStatisticsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitorStatisticsServiceStub(channel, callOptions);
        }
      };
    return MonitorStatisticsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MonitorStatisticsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitorStatisticsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitorStatisticsServiceBlockingStub>() {
        @java.lang.Override
        public MonitorStatisticsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitorStatisticsServiceBlockingStub(channel, callOptions);
        }
      };
    return MonitorStatisticsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MonitorStatisticsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitorStatisticsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitorStatisticsServiceFutureStub>() {
        @java.lang.Override
        public MonitorStatisticsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitorStatisticsServiceFutureStub(channel, callOptions);
        }
      };
    return MonitorStatisticsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MonitorStatisticsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void monitorStatistics(com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMonitorStatisticsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMonitorStatisticsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest,
                com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse>(
                  this, METHODID_MONITOR_STATISTICS)))
          .build();
    }
  }

  /**
   */
  public static final class MonitorStatisticsServiceStub extends io.grpc.stub.AbstractAsyncStub<MonitorStatisticsServiceStub> {
    private MonitorStatisticsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorStatisticsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitorStatisticsServiceStub(channel, callOptions);
    }

    /**
     */
    public void monitorStatistics(com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMonitorStatisticsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MonitorStatisticsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MonitorStatisticsServiceBlockingStub> {
    private MonitorStatisticsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorStatisticsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitorStatisticsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse monitorStatistics(com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest request) {
      return blockingUnaryCall(
          getChannel(), getMonitorStatisticsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MonitorStatisticsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MonitorStatisticsServiceFutureStub> {
    private MonitorStatisticsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorStatisticsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitorStatisticsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse> monitorStatistics(
        com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMonitorStatisticsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MONITOR_STATISTICS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MonitorStatisticsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MonitorStatisticsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MONITOR_STATISTICS:
          serviceImpl.monitorStatistics((com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsRequest) request,
              (io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.MonitorStatistics.MonitorStatisticsResponse>) responseObserver);
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
      synchronized (MonitorStatisticsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getMonitorStatisticsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
