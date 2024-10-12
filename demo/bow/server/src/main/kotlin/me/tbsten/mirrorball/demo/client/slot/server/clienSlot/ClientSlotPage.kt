package me.tbsten.mirrorball.demo.client.slot.server.clienSlot

import androidx.compose.runtime.Composable
import me.tbsten.mirrorball.bow.Script
import me.tbsten.mirrorball.bow.SerializableComposableLambda
import me.tbsten.mirrorball.bow.buildInfo.generated.BowClientScripts
import me.tbsten.mirrorball.bow.slot.ClientSlot
import me.tbsten.mirrorball.demo.client.slot.shared.BasicSlot
import me.tbsten.mirrorball.demo.client.slot.shared.SlotWithArgs
import me.tbsten.mirrorball.demo.client.slot.shared.SlotWithComposableArg
import me.tbsten.mirrorball.elements.Body
import me.tbsten.mirrorball.elements.Div
import me.tbsten.mirrorball.elements.H1
import me.tbsten.mirrorball.elements.H2
import me.tbsten.mirrorball.elements.Head
import me.tbsten.mirrorball.elements.Html
import me.tbsten.mirrorball.elements.Script

@Composable
fun ClientSlotPage(linkStyleSheet: @Composable () -> Unit) {
    Html {
        Head {
            linkStyleSheet()
            BowClientScripts.DemoBowClientClientSlot.Script()
        }
        Body {
            H1 {
                +"`ClientSlot` Demo"
            }
            Div {
                +"this render on server"
            }

            H2 {
                +"basic slot"
            }
            ClientSlot(BasicSlot)

            H2 {
                +"slot with args"
            }
            ClientSlot(SlotWithArgs(str = "test-1", int = 12345))

            H2 {
                +"slot with @Composable args"
            }
            ClientSlot(
                SlotWithComposableArg(
                    renderResult =
                        SerializableComposableLambda {
                            Div { +"this is render on server" }
                        },
                ),
            )
        }
    }
}
