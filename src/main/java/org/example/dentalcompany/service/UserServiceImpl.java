package org.example.dentalcompany.service;


import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import my.grpc.service.UserServiceProto;
import org.example.dentalcompany.entity.User;
import org.example.dentalcompany.repository.UserRepository;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class UserServiceImpl extends my.grpc.service.UserServiceGrpc.UserServiceImplBase {

    private final UserRepository userRepository;

    @Override
    public void getUserData(UserServiceProto.UserRequest request, StreamObserver<UserServiceProto.UserResponse> responseObserver) {
        try {

            User user = userRepository.findByMailAndPassword(
                    request.getMail(), request.getPassword()
            ).orElseThrow(() -> new RuntimeException("User not found or invalid credentials"));

            UserServiceProto.UserResponse response = mapToResponse(user);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    private UserServiceProto.UserResponse mapToResponse(User user) {
        return UserServiceProto.UserResponse.newBuilder()
                .setUserName(user.getName())
                .setUserRole(user.getRole().getName())
                .setCompanyId(String.valueOf(user.getCompany().getId()))
                .setUserId(String.valueOf(user.getId()))
                .build();
    }
}
