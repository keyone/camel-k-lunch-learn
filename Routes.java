import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
public class Routes extends RouteBuilder {
    public void configure() {
        from("telegram:bots?authorizationToken={{token}}")
                .filter(simple("${body.from.id} == 631284087"))
                .convertBodyTo(String.class)
                .choice()
                    .when(simple("${body.toLowerCase()} contains 'norris'"))
                        .to("http://api.icndb.com/jokes/random")
                        .unmarshal().json(JsonLibrary.Jackson)
                        .transform(simple("${body[value][joke]}"))
                        .to("telegram:bots?authorizationToken={{token}}")
                        .log("${body}")
                    .otherwise()
                        .log("Discarded: ${body}")
                .log("${body}");
    }
}
