package com.uab.service;

import com.uab.dto.euromil.EuroMilRegisterRequestDTO;
import com.uab.dto.euromil.EuroMilRegisterResponseDTO;
import euromil.EuromilGrpc;
import euromil.RegisterReply;
import euromil.RegisterRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class EuroMilService {

    @GrpcClient("euromil-grpc-server")
    private EuromilGrpc.EuromilBlockingStub simpleStub;

    public EuroMilRegisterResponseDTO registerEuroMil(EuroMilRegisterRequestDTO request) {
        final RegisterReply response = this.simpleStub.registerEuroMil(RegisterRequest.newBuilder()
            .setKey(request.getKey())
            .setCheckid(request.getCheckid())
            .build());

        return EuroMilRegisterResponseDTO.builder().message(response.getMessage()).build();
    }
}
