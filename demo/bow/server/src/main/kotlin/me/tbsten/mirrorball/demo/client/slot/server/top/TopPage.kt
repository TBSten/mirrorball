package me.tbsten.mirrorball.demo.client.slot.server.top

import androidx.compose.runtime.Composable
import me.tbsten.mirrorball.bow.Script
import me.tbsten.mirrorball.bow.buildInfo.generated.BowClientScripts
import me.tbsten.mirrorball.elements.A
import me.tbsten.mirrorball.elements.Body
import me.tbsten.mirrorball.elements.H1
import me.tbsten.mirrorball.elements.H2
import me.tbsten.mirrorball.elements.Head
import me.tbsten.mirrorball.elements.Html
import me.tbsten.mirrorball.elements.Li
import me.tbsten.mirrorball.elements.Ul
import me.tbsten.mirrorball.elements.href

@Composable
fun TopPage(linkStyleSheet: @Composable () -> Unit) {
    Html {
        Head {
            linkStyleSheet()
            BowClientScripts.DemoBowClientTop.Script()
        }
        Body {
            H1 {
                +"Bow Demo Site"
            }
            H2 {
                +"Contents"
            }

            Ul {
                Li {
                    A(attrs = { href("/client-slot") }) {
                        +"ClientSlot Demo"
                    }
                }
            }
        }
    }
}
