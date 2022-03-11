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
    comments = "Source: acceptance_list.proto")
public final class AcceptanceListServiceGrpc {

  private AcceptanceListServiceGrpc() {}

  public static final String SERVICE_NAME = "axis.transactions.AcceptanceListService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest,
      com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse> getGetAcceptanceListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAcceptanceList",
      requestType = com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest.class,
      responseType = com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest,
      com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse> getGetAcceptanceListMethod() {
    io.grpc.MethodDescriptor<com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest, com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse> getGetAcceptanceListMethod;
    if ((getGetAcceptanceListMethod = AcceptanceListServiceGrpc.getGetAcceptanceListMethod) == null) {
      synchronized (AcceptanceListServiceGrpc.class) {
        if ((getGetAcceptanceListMethod = AcceptanceListServiceGrpc.getGetAcceptanceListMethod) == null) {
          AcceptanceListServiceGrpc.getGetAcceptanceListMethod = getGetAcceptanceListMethod =
              io.grpc.MethodDescriptor.<com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest, com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAcceptanceList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetAcceptanceListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AcceptanceListServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AcceptanceListServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AcceptanceListServiceStub>() {
        @java.lang.Override
        public AcceptanceListServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AcceptanceListServiceStub(channel, callOptions);
        }
      };
    return AcceptanceListServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AcceptanceListServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AcceptanceListServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AcceptanceListServiceBlockingStub>() {
        @java.lang.Override
        public AcceptanceListServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AcceptanceListServiceBlockingStub(channel, callOptions);
        }
      };
    return AcceptanceListServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AcceptanceListServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AcceptanceListServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AcceptanceListServiceFutureStub>() {
        @java.lang.Override
        public AcceptanceListServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AcceptanceListServiceFutureStub(channel, callOptions);
        }
      };
    return AcceptanceListServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AcceptanceListServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAcceptanceList(com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAcceptanceListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAcceptanceListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest,
                com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse>(
                  this, METHODID_GET_ACCEPTANCE_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class AcceptanceListServiceStub extends io.grpc.stub.AbstractAsyncStub<AcceptanceListServiceStub> {
    private AcceptanceListServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AcceptanceListServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AcceptanceListServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAcceptanceList(com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest request,
        io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAcceptanceListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AcceptanceListServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AcceptanceListServiceBlockingStub> {
    private AcceptanceListServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AcceptanceListServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AcceptanceListServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse getAcceptanceList(com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAcceptanceListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AcceptanceListServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AcceptanceListServiceFutureStub> {
    private AcceptanceListServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AcceptanceListServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AcceptanceListServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse> getAcceptanceList(
        com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAcceptanceListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCEPTANCE_LIST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AcceptanceListServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AcceptanceListServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ACCEPTANCE_LIST:
          serviceImpl.getAcceptanceList((com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListRequest) request,
              (io.grpc.stub.StreamObserver<com.axismobfintech.gpb.transactions.AcceptanceList.AcceptanceListResponse>) responseObserver);
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
      synchronized (AcceptanceListServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getGetAcceptanceListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
