package com.jobportal.studentservice.config;

import com.jobportal.jobserviceproto.JobServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class JobServiceClientConfig {

    @Value("${jobservice.server.url}")
    private String url;

    private ManagedChannel channel;
    private JobServiceGrpc.JobServiceBlockingStub stub;

    public void start() {
        // Open channel
        channel = ManagedChannelBuilder.forTarget(url).usePlaintext().build();

        // Get the server stub through the channel
        stub = JobServiceGrpc.newBlockingStub(channel);
        log.info("gRPC client started, server address: {}", url);
    }

    public void shutdown() throws InterruptedException {
        // Wait 1 second to close the channel after calling the shutdown method
        channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        log.info("gRPC client shut down successfully.");
    }

    public JobServiceGrpc.JobServiceBlockingStub getStub() {
        return this.stub;
    }

}
