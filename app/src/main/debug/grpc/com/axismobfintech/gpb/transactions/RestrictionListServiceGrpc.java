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
    comments = "Source: restriction_list.proto")
public final class RestrictionListServiceGrpc {

  private RestrictionListServiceGrpc() {}

  public static final String SERVICE_NAME = "axis.transactions.RestrictionListService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest,
      com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse> getGetRestrictionListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRestrictionList",
      requestType = com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest.class,
      responseType = com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest,
      com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse> getGetRestrictionListMethod() {
    io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest, com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse> getGetRestrictionListMethod;
    if ((getGetRestrictionListMethod = RestrictionListServiceGrpc.getGetRestrictionListMethod) == null) {
      synchronized (RestrictionListServiceGrpc.class) {
        if ((getGetRestrictionListMethod = RestrictionListServiceGrpc.getGetRestrictionListMethod) == null) {
          RestrictionListServiceGrpc.getGetRestrictionListMethod = getGetRestrictionListMethod =
              io.grpc.MethodDescriptor.<com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest, com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRestrictionList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetRestrictionListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RestrictionListServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RestrictionListServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RestrictionListServiceStub>() {
        @java.lang.Override
        public RestrictionListServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RestrictionListServiceStub(channel, callOptions);
        }
      };
    return RestrictionListServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RestrictionListServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RestrictionListServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RestrictionListServiceBlockingStub>() {
        @java.lang.Override
        public RestrictionListServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RestrictionListServiceBlockingStub(channel, callOptions);
        }
      };
    return RestrictionListServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RestrictionListServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RestrictionListServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RestrictionListServiceFutureStub>() {
        @java.lang.Override
        public RestrictionListServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RestrictionListServiceFutureStub(channel, callOptions);
        }
      };
    return RestrictionListServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RestrictionListServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRestrictionList(com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRestrictionListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRestrictionListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest,
                com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse>(
                  this, METHODID_GET_RESTRICTION_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class RestrictionListServiceStub extends io.grpc.stub.AbstractAsyncStub<RestrictionListServiceStub> {
    private RestrictionListServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RestrictionListServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RestrictionListServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRestrictionList(com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRestrictionListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RestrictionListServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RestrictionListServiceBlockingStub> {
    private RestrictionListServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RestrictionListServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RestrictionListServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse getRestrictionList(com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRestrictionListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RestrictionListServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RestrictionListServiceFutureStub> {
    private RestrictionListServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RestrictionListServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RestrictionListServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse> getRestrictionList(
        com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRestrictionListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_RESTRICTION_LIST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RestrictionListServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RestrictionListServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RESTRICTION_LIST:
          serviceImpl.getRestrictionList((com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListRequest) request,
              (io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.RestrictionList.RestrictionListResponse>) responseObserver);
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
      synchronized (RestrictionListServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getGetRestrictionListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
