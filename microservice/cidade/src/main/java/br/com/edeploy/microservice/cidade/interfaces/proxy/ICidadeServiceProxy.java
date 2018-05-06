package br.com.edeploy.microservice.cidade.interfaces.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "cidade-service")
@RibbonClient(name = "cidade-service")
public interface ICidadeServiceProxy {
}
