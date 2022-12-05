package org.example;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: UpdateInfoService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UpdateInfoServiceGrpc {

  private UpdateInfoServiceGrpc() {}

  public static final String SERVICE_NAME = "org.example.UpdateInfoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.UpdateInfoRequest,
      org.example.UpdateInfoResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = org.example.UpdateInfoRequest.class,
      responseType = org.example.UpdateInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.UpdateInfoRequest,
      org.example.UpdateInfoResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<org.example.UpdateInfoRequest, org.example.UpdateInfoResponse> getUpdateMethod;
    if ((getUpdateMethod = UpdateInfoServiceGrpc.getUpdateMethod) == null) {
      synchronized (UpdateInfoServiceGrpc.class) {
        if ((getUpdateMethod = UpdateInfoServiceGrpc.getUpdateMethod) == null) {
          UpdateInfoServiceGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<org.example.UpdateInfoRequest, org.example.UpdateInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.UpdateInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.UpdateInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UpdateInfoServiceMethodDescriptorSupplier("update"))
              .build();
        }
      }
    }
    return getUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UpdateInfoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UpdateInfoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UpdateInfoServiceStub>() {
        @java.lang.Override
        public UpdateInfoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UpdateInfoServiceStub(channel, callOptions);
        }
      };
    return UpdateInfoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UpdateInfoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UpdateInfoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UpdateInfoServiceBlockingStub>() {
        @java.lang.Override
        public UpdateInfoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UpdateInfoServiceBlockingStub(channel, callOptions);
        }
      };
    return UpdateInfoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UpdateInfoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UpdateInfoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UpdateInfoServiceFutureStub>() {
        @java.lang.Override
        public UpdateInfoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UpdateInfoServiceFutureStub(channel, callOptions);
        }
      };
    return UpdateInfoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UpdateInfoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void update(org.example.UpdateInfoRequest request,
        io.grpc.stub.StreamObserver<org.example.UpdateInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.UpdateInfoRequest,
                org.example.UpdateInfoResponse>(
                  this, METHODID_UPDATE)))
          .build();
    }
  }

  /**
   */
  public static final class UpdateInfoServiceStub extends io.grpc.stub.AbstractAsyncStub<UpdateInfoServiceStub> {
    private UpdateInfoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdateInfoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UpdateInfoServiceStub(channel, callOptions);
    }

    /**
     */
    public void update(org.example.UpdateInfoRequest request,
        io.grpc.stub.StreamObserver<org.example.UpdateInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UpdateInfoServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UpdateInfoServiceBlockingStub> {
    private UpdateInfoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdateInfoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UpdateInfoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.UpdateInfoResponse update(org.example.UpdateInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UpdateInfoServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UpdateInfoServiceFutureStub> {
    private UpdateInfoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdateInfoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UpdateInfoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.UpdateInfoResponse> update(
        org.example.UpdateInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UpdateInfoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UpdateInfoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE:
          serviceImpl.update((org.example.UpdateInfoRequest) request,
              (io.grpc.stub.StreamObserver<org.example.UpdateInfoResponse>) responseObserver);
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

  private static abstract class UpdateInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UpdateInfoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.UpdateInfoServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UpdateInfoService");
    }
  }

  private static final class UpdateInfoServiceFileDescriptorSupplier
      extends UpdateInfoServiceBaseDescriptorSupplier {
    UpdateInfoServiceFileDescriptorSupplier() {}
  }

  private static final class UpdateInfoServiceMethodDescriptorSupplier
      extends UpdateInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UpdateInfoServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UpdateInfoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UpdateInfoServiceFileDescriptorSupplier())
              .addMethod(getUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
