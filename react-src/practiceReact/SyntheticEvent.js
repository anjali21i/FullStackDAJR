import React, { useEffect } from "react";
import "./styles.css";

//order   1> [parent div] native dom event triggered   2> [child button] synthetic event triggered   3> [parent div] synthetic event triggered  4> [document] native dom event triggered

const SyntheticEvent = () => {
    useEffect(() => {
        document.addEventListener("click", (e) => {
            // @4 stop parent native propogation
            e.stopPropagation();
            console.log("[document] native dom event triggered");
        });
        const parentDiv = document.getElementById("parent");
        parentDiv.addEventListener("click", (e) => {
            // @1 stop parent native propogation
            // e.stopPropagation();
            console.log("[parent div] native dom event triggered");
        });
    }, []);

    const onParentClick = (e) => {
        // @2 stop parent propogation
        // e.stopPropagation();
        console.log("[parent div] synthetic event triggered");
    };

    const onChildClick = (e) => {
        // @3 stop child propogation
        // e.stopPropagation();
        console.log("[child button] synthetic event triggered");
    };

    return (
        <div id="parent" onClick={onParentClick}>
            hello
            <button onClick={onChildClick}>child</button>
        </div>
    );
}

export default SyntheticEvent;