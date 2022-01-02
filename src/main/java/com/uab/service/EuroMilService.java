package com.uab.service;

import com.uab.model.euromil.RegisterRequestDTO;
import com.uab.model.euromil.RegisterResponseDTO;
import euromil.EuroMil;
import euromil.EuromilGrpc;
import euromil.RegisterReply;
import euromil.RegisterRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class EuroMilService {

    @GrpcClient("euromil-grpc-server")
    private EuromilGrpc.EuromilBlockingStub simpleStub;

    public RegisterResponseDTO registerEuroMil(RegisterRequestDTO request) {
        final RegisterReply response = this.simpleStub.registerEuroMil(RegisterRequest.newBuilder()
            .setKey(request.getKey())
            .setCheckid(request.getCheckid())
            .build());

        return RegisterResponseDTO.builder().message(response.getMessage()).build();
    }
}
