package resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.TransferService;
import service.TransferServiceImpl;
import spark.Request;
import spark.Response;
import spark.Route;

public class TransferResource {

    public static Route transfer = (Request request, Response response) -> {
        TransferVO transferVO = getTransferVO(request);
        TransferService service = new TransferServiceImpl();
        try {
            service.transfer(transferVO);

        } catch (Exception e) {
            response.status(422);
            return e.getMessage();
        }
        return transferVO;
    };

    private static TransferVO getTransferVO(Request request) throws java.io.IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(request.body(), TransferVO.class);
    }
}
